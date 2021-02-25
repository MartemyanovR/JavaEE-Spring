package ru.mart.hibernateAnnotationProject.dao;

import java.sql.SQLException;
import java.util.List;

import ru.mart.hibernateAnnotationProject.entity.Person;

public interface PersonDao {

		//create
		void add(Person person) throws SQLException;
		
		//read all
		List<Person> getAll() throws SQLException;

		//read by id
		Person getById(Long id) throws SQLException;
		
		//update
		void update(Person person) throws SQLException;
		
		//delete
		void remove(Person person) throws SQLException;	
}
