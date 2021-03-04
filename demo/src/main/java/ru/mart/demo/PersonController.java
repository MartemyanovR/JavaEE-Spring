package ru.mart.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

	Repository repository = new Repository();	
	
	@GetMapping("/person")
	public Person getPerson(@RequestParam(value = "name") String name) {
		return repository.personByName(name);
	}
	
	@PostMapping("/person")
	public Person update(@RequestParam(value = "name")String name,@RequestParam(value = "age") int age) {
		Person person = repository.personByName(name);
		if(person != null) {
			person.setAge(age);
			return person;
		} else { 
			Person newPerson = new Person(name,age);
			repository.addPerson(newPerson);
			return newPerson;
		}
	}
	
}
