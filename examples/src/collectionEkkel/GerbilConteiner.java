package collectionEkkel;

import java.util.ArrayList;
import java.util.Iterator;

public class GerbilConteiner {
	public static void main(String[] args) {
	ArrayList<Gerbil> gerbil = new ArrayList<>();
	int i = 0;
	while(i<3) {
		gerbil.add(new Gerbil(i));
		i++;
		}
	for (int j=0; j< gerbil.size(); j++) {
		gerbil.get(j).hop();
		}
	display(gerbil.iterator());
	}
	// Задание 8 стр 339.Измените упражнение 1 так,Измените упражнение 1 так,
	// чтобы для перемещения по контейнеру List при вызовах hop() использовался итератор Iterator.
	public static void display(Iterator<Gerbil> it) {
		System.out.println("This is iterator");
		while(it.hasNext()) {
			Gerbil g = it.next();
			g.hop();
		}
	}
}
