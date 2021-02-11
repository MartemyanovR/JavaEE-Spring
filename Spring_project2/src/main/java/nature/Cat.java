package nature;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Cat implements Animals {
	private List<String> move = Arrays.asList("sleep", "eat", "shit");

	@Override
	public String volume() {
	//	System.out.println("meow");
		return "meow";
	}

	@Override
	public String getmove(int index) {
		return move.get(index);
	}
	
	@Override
	public String toString() {
		return "Cat";
	}	
		
}
