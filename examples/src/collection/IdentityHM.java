package collection;

import java.util.HashMap;
import java.util.IdentityHashMap;

import collection.collision.Person;

public class IdentityHM {

	public static void main(String[] args) {
		IdentityHashMap<Person, Integer> ihm = new IdentityHashMap<Person, Integer>();
		HashMap<Person, Integer> hm = new HashMap<Person, Integer>();
		
		Person mut = new Person("tom",41);
		
		
		ihm.put(new Person("charlie",48), 1);
		ihm.put(new Person("bob",47), 2);
		ihm.put(mut, 3);
		ihm.put(new Person("bob",47), 4);
		
		

		hm.put(new Person("charlie",48), 1);
		hm.put(new Person("bob",47), 2);
		hm.put(mut, 3);
		hm.put(new Person("bob",47), 4);
	
		System.out.println(ihm);
		System.out.println(hm);
		
		mut.setName("karl");
		
		System.out.println(ihm);
		System.out.println(hm);
		
		
	}
	

}
