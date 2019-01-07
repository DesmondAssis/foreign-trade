package com.desmond.foreigntrade.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan({"com.desmond"})
@SpringBootApplication
public class CompanyApiApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(CompanyApiApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(CompanyApiApplication.class);
	}

}

