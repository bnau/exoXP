package com.bnau.cdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class CdbApplication extends SpringBootServletInitializer {
	
	public static void main(final String... args ) {
		SpringApplication.run(CdbApplication.class, args);
	}
	
}
