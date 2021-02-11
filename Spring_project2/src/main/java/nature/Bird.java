package nature;

import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class Bird implements Animals {
	private List<String> move = Arrays.asList("fly", "song", "peck");
	
	@PostConstruct
	public void doBirdInit() {
		System.out.println("I initialized!");
	}
	
	@PreDestroy
	public void doBirdDestroy() {
		System.out.println("The end...");
	}

	public String volume() {
		System.out.println("chikk");
		return "chikk";
	}
	
	@Override
	public String getmove(int index) {
		return move.get(index);
	}
	
	@Override
	public String toString() {
		return "Bird";
	}
	
	
	
}
