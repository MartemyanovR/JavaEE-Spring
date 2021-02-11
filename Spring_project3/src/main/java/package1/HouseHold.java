package package1;

import org.springframework.stereotype.Component;

@Component
public class HouseHold implements Product {
	
	public void applied() {
		System.out.println("for household");		
	}


}
