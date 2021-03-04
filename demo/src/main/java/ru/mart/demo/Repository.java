package ru.mart.demo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Repository {
	
	static Map<String, Person> persons = new ConcurrentHashMap<>();
	
	static {
		persons.put("Bob" , new Person("Bob", 35));
		persons.put("Tom" , new Person("Tom", 55));
		persons.put("Jonh" , new Person("Jonh", 85));
		persons.put("Jack" , new Person("Jack", 75));
		persons.put("Dev" , new Person("Dev", 37));
	}
	
	public Person personByName(String name) {
		return persons.get(name);
	}
	
	public Person addPerson(Person person) {
		persons.put(person.getName(), person); 			
		return person;
	}

}
