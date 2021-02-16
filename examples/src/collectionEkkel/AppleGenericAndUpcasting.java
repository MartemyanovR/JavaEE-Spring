package collectionEkkel;

import java.util.ArrayList;

public class AppleGenericAndUpcasting {
		//Восходящее преобразование работает с обобщенными типами точно так же, как и с любыми другими типами:
	public static void main(String[] args) {
		ArrayList<Apple> apples = new ArrayList<>(); 
		apples.add(new AppleGala());
		apples.add(new AppleGolden());
		apples.add(new Apple());
		for (Apple a : apples) {
			System.out.println(a.toString() + " id " +  a.id());
		}
	}
}
