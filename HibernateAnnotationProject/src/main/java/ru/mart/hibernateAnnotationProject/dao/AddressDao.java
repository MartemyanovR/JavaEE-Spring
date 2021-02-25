package ru.mart.hibernateAnnotationProject.dao;

import java.sql.SQLException;
import java.util.List;

import ru.mart.hibernateAnnotationProject.entity.Address;

public interface AddressDao {
	
	//create
	void add(Address address) throws SQLException;
	
	//read all
	List<Address> getAll() throws SQLException;

	//read by id
	Address getById(Long id) throws SQLException;
	
	//update
	void update(Address address) throws SQLException;
	
	//delete
	void remove(Address adress) throws SQLException;
}
