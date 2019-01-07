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
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private SConfig sConfig;

    @Autowired
    private DbConfig dbConfig;

    @Bean(name = "bizDataSource")
    @Primary
    public DataSource bizDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();

        BeanUtils.copyProperties(dbConfig, druidDataSource);

        return druidDataSource;
    }

    @Bean(name = "bizSqlSessionFactory")
    @Primary
    public SqlSessionFactory bizSqlSessionFactory(@Qualifier("bizDataSource") DataSource dataSource) throws Exception {
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
}
