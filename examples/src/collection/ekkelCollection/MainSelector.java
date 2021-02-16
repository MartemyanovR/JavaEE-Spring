package collection.ekkelCollection;

import java.util.Iterator;

//Коллекции обьектов, задание №3
public class MainSelector {
	public static void main(String[] args) { 
	SequenceWithInnerClass<String> swic = new SequenceWithInnerClass<String>();
	swic.add("One");
	swic.add("Two");
	swic.add("three");
	swic.add("four");
	swic.add("five");
	swic.add("six");
	Selector<String> selector = swic.methodAccessInnerSequenceSelector();
	while(!selector.end()) {
		System.out.print(selector.current() + ", ");
		selector.next();
		}
	System.out.println("\n");
	Iterator<String> iter = swic.methodAccessSequenceSelectorIterator();
	while(iter.hasNext()) {
		System.out.print(iter.next() + ", ");
	}
	}
	
}
