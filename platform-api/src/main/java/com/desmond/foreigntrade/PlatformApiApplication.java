package com.desmond.foreigntrade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan({"com.desmond"})
@SpringBootApplication
public class PlatformApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PlatformApiApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PlatformApiApplication.class);
	}

}

