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
		peoples.add(new Person(++COUNT, "Alex", "Petrov", "123@mail.ru"));
		peoples.add(new Person(++COUNT, "Emma", "Fuga", "emma@gmail.ru"));
		peoples.add(new Person(++COUNT, "Tom", "Jeckson", "jek@yandex.ru"));
		peoples.add(new Person(++COUNT, "Jenna", "Smit", "smit@rambler.ru"));		
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
	
	public void save(Person person) {
		person.setId(++COUNT);
		peoples.add(person);
	}
	
	
	
	
	
	
	
	
	

}
