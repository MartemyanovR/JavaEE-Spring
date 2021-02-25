package main;

import java.sql.Date;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;

import entity.Address;
import entity.Car;
import entity.Person;
import utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		Session session  = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		
		try {
		transaction = (Transaction) session.beginTransaction();
		
		Address address = new Address();
		address.setCountry("UK");
		address.setCity("Bath");
		address.setStreet("Barton-street");
		address.setPostCode(123);
		
		Person person = new Person();
		person.setFirstName("Jon");
		person.setLastName("Jackson");
		person.setAddress(address);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2002, Calendar.APRIL, 5);
		person.setBirthDay(new Date(calendar.getTime().getTime()));
		
		Car car = new Car();
		car.setMark("Rover");
		car.setType("sedan");
		
		Set<Car> cars = new HashSet<>();
		cars.add(car);
		person.setCars(cars);
		
		session.save(address);
		session.save(car);
		session.save(person);
		
		session.getTransaction().commit();
		} catch(Exception e) {
			if(transaction != null) {
				try {
					// в случае исключения, происходит откат (rollback)
					transaction.rollback();
				} catch (IllegalStateException | SystemException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			HibernateUtil.shutDown();
		}				
	}
}
