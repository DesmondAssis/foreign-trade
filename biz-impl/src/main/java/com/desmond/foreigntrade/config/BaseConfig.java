package com.desmond.foreigntrade.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author presleyli
 * @date 2019/1/2 6:21 PM
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "base")
public class BaseConfig {
    private String configPropertiesLocation;
    private String filePath;
}
