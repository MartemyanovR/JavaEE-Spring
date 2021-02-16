package dataStructures;

import java.util.*;

public class LinkedLisTest {
	public static void main (String[] args) {
		List <String> a = new LinkedList();
		a.add("Amy");
		a.add("Carl");
		a.add("Erica");
		List <String> b = new LinkedList();
		b.add("Bob");
		b.add("Doug");
		b.add("Frances");
		b.add("Gloria");
		
		// объединить слова из связных списков		
		ListIterator<String> aIter = a.listIterator();  
		ListIterator<String> bIter = b.listIterator(); 
		/*Iterator<String> bIter = b.iterator();
		
		System.out.println(b.addAll(4,a));
		System.out.println(b);
		System.out.println(b.remove(6));
		System.out.println(b);
		b.set(2, "Piter");
		System.out.println(b);
		System.out.println(b.indexOf("Carl"));
		System.out.println(b.lastIndexOf("Carl"));
		b.add("Pyvel");
		System.out.println(b);
		aIter.next();
		aIter.add("e");
		System.out.println(a);	*/
		
		while(bIter.hasNext()) {
			if(aIter.hasNext()) aIter.next();
			aIter.add(bIter.next());
			}
		System.out.println(a);
		
		//удалить каждое второе слово из связного списка
		//bIter = b.iterator();
		while(bIter.hasNext()) {
			bIter.next();  //пропустить один элемент
			if(bIter.hasNext()) {
				bIter.next();
				bIter.remove();
			}
		}
		System.out.println(b);
		
		//операция удаления всех слов из списка "а" состовляющих связный список "в"
		a.removeAll(b);
		
		System.out.println(a);
		
		
	}

}
