package com.SpringCoreAnnotations.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ChickenPizza chickenPizza() {
		return new ChickenPizza();
	}
	
	
}
