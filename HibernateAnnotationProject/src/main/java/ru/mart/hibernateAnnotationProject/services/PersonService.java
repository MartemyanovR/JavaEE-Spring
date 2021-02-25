package ru.mart.hibernateAnnotationProject.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.query.Query;

import org.hibernate.Session;

import ru.mart.hibernateAnnotationProject.dao.PersonDao;
import ru.mart.hibernateAnnotationProject.entity.Person;
import ru.mart.hibernateAnnotationProject.utils.SessionUtil;

public class PersonService extends SessionUtil implements PersonDao{

	@Override
	public void add(Person person) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.save(person);
		closeTransactionSession();		
	}

	@Override
	public List<Person> getAll() throws SQLException {
		String sql = "SELECT * FROM Person";
		Session session = getSession();
		Query<?> query = session.createNativeQuery(sql).addEntity(Person.class);
		@SuppressWarnings("unchecked")
		List<Person> listPerson = (List<Person>) query.list(); 
		closeTransactionSession();
		return listPerson;
	}

	@Override
	public Person getById(Long id) throws SQLException {
		String sql = "SELECT * FROM Person WHERE ID=:id";
		openTransactionSession();
		Session session = getSession();
		Query<?> query = session.createNativeQuery(sql).addEntity(Person.class);
		query.setParameter("ID", id);
		Person person = (Person) query.getSingleResult();
		closeTransactionSession();
		return person;
	}

	@Override
	public void update(Person person) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.update(person);
		closeTransactionSession();			
	}

	@Override
	public void remove(Person person) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.remove(person);
		closeTransactionSession();		
	}
	
	

}
