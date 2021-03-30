package ru.mart.spring_project_0_test_Di.init_test;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:init.properties")
public class ConfigSinger {
	
	@Bean
	@Lazy
	public Singer oneSinger() { return new Singer("Volodya", 41); }

	@Bean
	@Lazy
	public Singer twoSinger() { return new Singer(55); }
	
	@Bean
	@Lazy
	public Singer threeSinger() { return new Singer("Yakov",32); }
	
	@Bean
	@Lazy
	public Singer fourSinger() { 
		Singer sing = new Singer();
		sing.setName("Roman");
		sing.setAge(34);
		return sing; }
	
	@Bean
	@Lazy
	public Singer fiveSinger() { 
		Singer sing = new Singer();
		sing.setName("SetBean");
		sing.setAge(340);		
		return sing;
		}
	
}
