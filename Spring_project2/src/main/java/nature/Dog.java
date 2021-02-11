package nature;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dogi")
@Scope(value = "singleton")
public class Dog implements Animals{
	private List<String> move = Arrays.asList("guard", "be friends", "playing");			

	@Override
	public String volume() {
		//System.out.println("GAV");
		return "GAV";
	}
	
	@Override
	public String getmove(int index) {
		return move.get(index);
	}	
	

	@Override
	public String toString() {
		return "Dog";
	}
	

}
