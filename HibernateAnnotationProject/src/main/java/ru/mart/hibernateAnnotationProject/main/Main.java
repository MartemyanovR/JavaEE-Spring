package ru.mart.hibernateAnnotationProject.main;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import ru.mart.hibernateAnnotationProject.entity.Address;
import ru.mart.hibernateAnnotationProject.entity.Car;
import ru.mart.hibernateAnnotationProject.entity.Person;
import ru.mart.hibernateAnnotationProject.services.AddressService;
import ru.mart.hibernateAnnotationProject.services.CarService;
import ru.mart.hibernateAnnotationProject.services.PersonService;
import ru.mart.hibernateAnnotationProject.utils.HibernateUtil;

public class Main {

	public static void main(String[] args) {
		AddressService addressService = new AddressService();
		PersonService personService = new PersonService(); 
		CarService carService = new CarService();
		
		Address address1 = new Address();
		address1.setCountry("Russia");
		address1.setCity("Krasnodar");
		address1.setStreet("Sormovskaya");
		address1.setPostCode(158);
		
		Address address2 = new Address();
		address2.setCountry("Russia");
		address2.setCity("Rostov-na-Donu");
		address2.setStreet("Kirrilova");
		address2.setPostCode(88);
		
		Person person = new Person();
		person.setFirstName("Dmitriy");
		person.setLastName("Popov");
		person.setAddress(address1);
		
		Calendar calendar = Calendar.getInstance();
		calendar.set(2002, Calendar.APRIL, 5);
		person.setBirthDay(new Date(calendar.getTime().getTime()));
				
		Person person2 = new Person();
		person2.setFirstName("Fedor");
		person2.setLastName("Zhdanov");
		person2.setAddress(address2);
		
		calendar.set(2010, Calendar.MARCH, 25);
		person2.setBirthDay(new Date(calendar.getTime().getTime()));		
		
		Car car = new Car();
		car.setMark("VAZ");
		car.setType("Hatchback");
		
		Car car1 = new Car();
		car1.setMark("AUDI");
		car1.setType("Sedan");

		Car car2 = new Car();
		car2.setMark("Toyota");
		car2.setType("Hatchback");
		
		Set<Car> cars = new HashSet<>();
		cars.add(car);
		cars.add(car1);
		cars.add(car2);
		person.setCars(cars);
		person2.setCars(cars);
		
		Set<Person> persons = new HashSet<Person>();
		persons.add(person);
		persons.add(person2);
		car.setPersons(persons);
		car1.setPersons(persons);
		car2.setPersons(persons);
		
		try {
			addressService.add(address1);
			addressService.add(address2);
			personService.add(person);
			personService.add(person2);
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			HibernateUtil.shutDown();
		}

	}
}
