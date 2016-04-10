package com.itclass.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Application {

	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setUrl("jdbc:h2:~/newsdb");
		dataSource.setUsername("igor");
		dataSource.setPassword("123");
		dataSource.setDriverClassName("org.h2.Driver");
		
		return dataSource;
	}
	
}
