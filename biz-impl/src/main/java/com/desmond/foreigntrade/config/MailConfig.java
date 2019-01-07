package com.desmond.foreigntrade.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.PostConstruct;

/**
 * Created by presleyli on 2018/1/4.
 */
@Configuration
@ConfigurationProperties(prefix = "mail")
@Data
public class MailConfig {
    @Autowired
    private SConfig sConfig;

    private String host;
    private int port;
    private String defaultEncoding;
    private String username;
    private String password;

    private String sender;
    private String reciever;

    @PostConstruct
    public void init() {
        this.username = sConfig.getProperties().getProperty(this.getUsername());
        this.password = sConfig.getProperties().getProperty(this.getPassword());
        this.sender = sConfig.getProperties().getProperty(this.getSender());
        this.reciever = sConfig.getProperties().getProperty(this.getReciever());
    }
}
