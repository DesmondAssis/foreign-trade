package com.desmond.foreigntrade.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.io.VFS;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.SpringBootVFS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Created by Administrator on 2017-10-31.
 */
@Configuration
@MapperScan(basePackages = DataSourceBizConfig.BASE_PACKAGES, sqlSessionFactoryRef = "bizSqlSessionFactory")
public class DataSourceBizConfig {
    public final static String BASE_PACKAGES = "com.desmond.foreigntrade.dao";
    private final static String CONFIGURATION_LOCATIONS = "classpath:sqlmap/mybatis-biz-config.xml";
    private final static String MAPPER_LOCATIONS = "classpath:sqlmap/biz/**/*.xml";

    @Value("${base.jdbc-properties-location}")
    private String jdbcProperties;

    @Autowired
    private ApplicationContext applicationContext;

    @Bean
    public JdbcProperties jdbcProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(jdbcProperties));

            JdbcProperties jdbcProperties = new JdbcProperties();
            jdbcProperties.setUrl(String.valueOf(properties.get("url")));
            jdbcProperties.setUsername(String.valueOf(properties.get("username")));
            jdbcProperties.setPassword(String.valueOf(properties.get("password")));

            return jdbcProperties;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Bean(name = "bizDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    @Primary
    public DataSource bizDataSource() {
        //return DataSourceBuilder.createOrUpdate().build();
        DruidDataSource druidDataSource = new DruidDataSource();

        return druidDataSource;
    }

    private void fillProperJdbcProperties(DataSource dataSource) {
        DruidDataSource druidDataSource = (DruidDataSource) dataSource;

        JdbcProperties properties = jdbcProperties();
        druidDataSource.setUrl(properties.getUrl());
        druidDataSource.setUsername(properties.getUsername());
        druidDataSource.setPassword(properties.getPassword());
    }

    @Bean(name = "bizSqlSessionFactory")
    @Primary
    public SqlSessionFactory bizSqlSessionFactory(@Qualifier("bizDataSource") DataSource dataSource) throws Exception {
        fillProperJdbcProperties(dataSource);

        //解决myBatis下不能嵌套jar文件的问题
        VFS.addImplClass(SpringBootVFS.class);
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setTypeAliasesPackage("com.desmond.foreigntrade.entity");
        bean.setConfigLocation(new PathMatchingResourcePatternResolver().getResource(CONFIGURATION_LOCATIONS));
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATIONS));
        return bean.getObject();
    }

    @Bean(name = "bizTransactionManager")
    @Primary
    public DataSourceTransactionManager bizTransactionManager(@Qualifier("bizDataSource") DataSource dataSource) {
        fillProperJdbcProperties(dataSource);

        DataSourceTransactionManager myDataSourceTransactionManager = new DataSourceTransactionManager(dataSource);
        myDataSourceTransactionManager.setGlobalRollbackOnParticipationFailure(true);
        myDataSourceTransactionManager.setNestedTransactionAllowed(true);
        return myDataSourceTransactionManager;
    }

    @Bean(name = "bizSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate bizSqlSessionTemplate(@Qualifier("bizSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class JdbcProperties {
        private String url;
        private String username;
        private String password;
    }
}
