package package1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "package1")
@PropertySource("classpath:initial.properties")
public class SpringConfig {
	
	
	
	
/*	//ручное создание бинов и DI
	@Bean
	public Electronics electronics() {return new Electronics();	}
	@Bean
	public Product food() {return new Food();}	
	@Bean
	public Product houseHold () {return new HouseHold();}
	@Bean
	public Store store() {return new Store(electronics(), houseHold());	}   */


}
