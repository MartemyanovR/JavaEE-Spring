package springCrud.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import springCrud.models.Person;

//@Component
public class PersonDao {
	
	private static int COUNT;
	private List<Person> peoples;	
	
	public PersonDao() {
		peoples = new ArrayList<>();
		peoples.add(new Person(++COUNT, "Alex", "Petrov", 32, "123@mail.ru"));
		peoples.add(new Person(++COUNT, "Emma", "Fuga", 25, "emma@gmail.ru"));
		peoples.add(new Person(++COUNT, "Tom", "Jeckson",71, "jek@yandex.ru"));
		peoples.add(new Person(++COUNT, "Jenna", "Smit",15, "smit@rambler.ru"));		
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

	public void update(int id, Person updatedPerson) {
		Person personToBeUpdated = show(id);
		personToBeUpdated.setName(updatedPerson.getName());
		personToBeUpdated.setSurname(updatedPerson.getSurname());
		personToBeUpdated.setAge(updatedPerson.getAge());
		personToBeUpdated.setEmail(updatedPerson.getEmail());
	}

	public void delete(int id) {
		peoples.removeIf(p -> p.getId()==id);
		
	}
	
	
	
	
	
	
	
	
	

}
