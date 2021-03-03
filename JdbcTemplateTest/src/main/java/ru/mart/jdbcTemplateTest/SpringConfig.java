package ru.mart.jdbcTemplateTest;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class SpringConfig  {
	
/*	private final ApplicationContext applicationContext;
	
	@Autowired
	public SpringConfig(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}*/	
	
	 @Bean
	 public DataSource dataSource() {
	   	DriverManagerDataSource dataSource = new DriverManagerDataSource();
	   	dataSource.setDriverClassName("org.h2.Driver");
	   	dataSource.setUrl("jdbc:h2:C:/H2/test");
	   	dataSource.setUsername("sa");
	   	dataSource.setPassword("");
	   	
	   	return dataSource;
	 }
	    
	 @Bean
	 public JdbcTemplate jdbcTemplate() {
	  	return new JdbcTemplate(dataSource());
	 }
	    
	 @Bean
		public DeveloperService devService() {
			return new DeveloperService(jdbcTemplate());		
		}
	

}
