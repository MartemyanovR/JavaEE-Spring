package nature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class City {
	private String name;
	private Zoo zoo;
	
	@Autowired
	public City( Zoo zoo) {
		this.name = "Moscow";
		this.zoo = zoo;
	}
	
	public String toString() {
		return "City name: " + name + 
						". Zoo: " + zoo +
							", animal: " +  zoo.getAnimal() + 
									"  animal song: " + zoo.askMe();
	}
	
	

}
