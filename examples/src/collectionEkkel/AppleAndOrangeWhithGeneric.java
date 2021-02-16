package collectionEkkel;

import java.util.ArrayList;

public class AppleAndOrangeWhithGeneric {

	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<Apple>();
		for(int i = 0; i<3; i++) {
			apples.add(new Apple());
		}
		//will not pass
	//	apples.add(new Orange());
		for (int i=0; i< apples.size(); i++)
			System.out.println(apples.get(i).id());
		System.out.println("application 'for each'");
		for(Apple a : apples)
			System.out.println(a.id());
	}	
	

}
