package com.desmond.foreigntrade.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author presleyli
 * @date 2019/1/2 10:20 PM
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "spring.datasource")
public class DbConfig {
    @Autowired
    private SConfig sConfig;

    private String type;
    private String driverClassName;
    private String url;
    private String username;
    private String password;

    private String initialSize;
    private String minIdle;
    private String maxActive;
    private String maxWait;
    private String timeBetweenEvictionRunsMillis;
    private String minEvictableIdleTimeMillis;
    private String validationQuery;
    private String testWhileIdle;
    private String testOnBorrow;
    private String testOnReturn;
    private String poolPreparedStatements;
    private String maxPoolPreparedStatementPerConnectionSize;
    private String connectionProperties;

    @PostConstruct
    public void init() {
        this.url = sConfig.getProperties().getProperty(this.getUrl());
        this.username = sConfig.getProperties().getProperty(this.getUsername());
        this.password = sConfig.getProperties().getProperty(this.getPassword());
    }
}
