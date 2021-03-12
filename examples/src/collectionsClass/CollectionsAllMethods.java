package collectionsClass;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class CollectionsAllMethods {

	public static void main(String[] args) {
		
		List<String> listString = Arrays.asList("one","two","three","four","five","six");
		
		Cat catFox = new Cat("Fox", 5);
		Cat catShurik = new Cat("Shurik", 6);
		Cat catMuha = new Cat("Muha", 8);
		
		ArrayList<Feline> listFel = new ArrayList<>();
		listFel.add(new Feline(5));
		listFel.add(new Feline(7));
		listFel.add(new Feline(18));
		
		ArrayList<Cat> listCat = new ArrayList<>();
		listCat.add(new Cat("Bars", 3));
		listCat.add(catFox);
		listCat.add(catShurik);
		listCat.add(catMuha);
		listCat.add(new Cat("Kiti", 11));
		
		Cat[] arCat = {new Cat("one",1), new Cat("two",2), new Cat("three",3)};
		Feline[] arFel = {new Feline(100), new Feline(200), new Feline(300)};
		
		Collections.addAll(listCat, arCat);  //добавление из массива
		System.out.println(listCat);
		
		Collections.addAll(listFel, arCat); //добавление из массива подтипа , тк Collections.addAll(Collection<? super Cat> c, Cat... elements)
		System.out.println(listFel);
		
		Animal leon = new Animal("Leon", 200);
		Queue<Animal> animalQue = Collections.asLifoQueue(new ArrayDeque<Animal>());  // преобразование колекции в очередь
		animalQue.add(new Animal("leopards", 75));
		animalQue.add(new Animal("cats", 10));
		animalQue.add(new Animal("tiger", 120));
		System.out.println(animalQue.toString());
		
		System.out.println(Collections.binarySearch(listCat,catFox));  //двоичный поиск
		
		List<Feline> felineListCheck = Collections.checkedList(listFel, Feline.class); //проверка типа, с <> работает так же
		felineListCheck.add(catMuha);
		System.out.println(felineListCheck.toString());
//		listFel.add((Feline)leon);   //classCastException:
		//felineListCheck.add((Feline)leon);
		
		System.out.println(Collections.disjoint(listCat, animalQue)); //true если коллекции не имеют общих элементов
		@SuppressWarnings("unused")
		Iterator<?>  iter = Collections.emptyIterator(); //возвращает пустой итератор https://coderoad.ru/26288670/Использование-emptyIterator-в-java
		
		Collections.fill(listString, "ten"); //заполняет все содержимое коллекции указаным обьектом
		System.out.println(listString);
		System.out.println(Collections.frequency(listCat,catFox)); //проверяет если уазаный обьект equals содержимого, возвращает количество совподений
	}
	

}
