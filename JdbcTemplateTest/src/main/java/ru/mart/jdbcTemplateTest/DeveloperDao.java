package ru.mart.jdbcTemplateTest;

import java.util.List;

import javax.sql.DataSource;

public interface DeveloperDao {

//	void setDataSource(/*DataSource dataSource*/);
	void createDeveloper(String name, String specialty, Integer expirience);
	Developer getDeveloperById(Integer id);
	void updateDeveloper(Integer id, String name, String specialty, Integer expirience);
	void removeDeveloper(Integer id);
	List<Developer> listDevelopers();
	
}
