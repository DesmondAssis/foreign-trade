package com.desmond.foreigntrade.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author presleyli
 * @date 2019/1/2 7:15 PM
 */
@Data
@Component
@ConfigurationProperties(prefix = "s")
public class SConfig {
    private String fileDomain;
    private String companyDomain;
    private String platformDomain;

    @Autowired
    private BaseConfig baseConfig;

    private Properties properties = new Properties();

    @PostConstruct
    public void loadProperties() {
        try {
            properties.load(new FileInputStream(baseConfig.getConfigPropertiesLocation()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getFileDomain() {
        return properties.getProperty(fileDomain);
    }

    public String getCompanyDomain() {
        return  properties.getProperty(companyDomain);
    }

    public String getPlatformDomain() {
        return  properties.getProperty(platformDomain);
    }
}
