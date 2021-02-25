package ru.mart.hibernateAnnotationProject.dao;

import java.sql.SQLException;
import java.util.List;

import ru.mart.hibernateAnnotationProject.entity.Car;

public interface CarDao {
	
	//create
	void add(Car car) throws SQLException;
			
	//read all
	List<Car> getAll() throws SQLException;

	//read by id
	Car getById(Long id) throws SQLException;
			
	//update
	void update(Car car) throws SQLException;
		
	//delete
	void remove(Car car) throws SQLException;	

}
