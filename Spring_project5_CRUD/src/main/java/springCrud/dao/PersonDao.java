package springCrud.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import springCrud.models.Person;

@Component
public class PersonDao {
	
	private static int COUNT;
	private List<Person> peoples;
	
	
	public PersonDao() {
		peoples = new ArrayList<>();
		peoples.add(new Person(++COUNT, "Alex"));
		peoples.add(new Person(++COUNT, "Emma"));
		peoples.add(new Person(++COUNT, "Tom"));
		peoples.add(new Person(++COUNT, "Jenna"));		
	}
	
	public List<Person> index() {
		return peoples;
	}
	
	public Person show(int id) {
		for(Person p : peoples) {
			if(p.getId()==id) {
				return p;
			}
		}		
		return null;
	}
	
	
	
	
	
	
	
	
	

}
