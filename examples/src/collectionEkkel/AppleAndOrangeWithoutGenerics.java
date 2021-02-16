package collectionEkkel;

import java.util.ArrayList;

public class AppleAndOrangeWithoutGenerics {

	public static void main(String[] args) {
		ArrayList apples = new ArrayList();
		for (int i=0; i<3; i++) {
			apples.add(new Apple());	
		}
		// Не мешает добавить Orange в apples:
		apples.add(new Orange());
		for (int i= 0; i<apples.size(); i++)
			((Apple)apples.get(i)).id();
		// Объект Orange обнаруживается только во время выполнения
	}

}
