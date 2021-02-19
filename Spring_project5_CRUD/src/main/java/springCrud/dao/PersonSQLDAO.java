package springCrud.dao;

import java.util.List;

import springCrud.models.Person;

public interface PersonSQLDAO {	
	
	//create table
	void addTable();

	//create
	void add(Person person);
	
	//read
	List<Person> getAll();
	
	//get by id
	Person getById(int id);
	
	//update
	void update(Person person);	
	
	//remove
	void remove(Person person);
	
	//add first default person
	void firstPerson();
	
	
	
}
