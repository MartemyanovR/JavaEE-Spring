package package1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class Food implements Product {
	
	@PostConstruct
	private void doInitFood() {
		System.out.println("Init Food");
	}
	@PreDestroy
	private void doDestroyFood() {
		System.out.println("Destroying Food");
	}
	
	public void applied() {
		System.out.println("to eat");
	}

}
