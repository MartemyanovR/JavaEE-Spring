package carsManager.dao;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import carsManager.model.Car;


@Repository
public class CarDaoImpl implements CarDao {
	private static final Logger logger = LoggerFactory.getLogger(CarDaoImpl.class);
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	

	@Override
	public void addCar(Car car) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(car);
		logger.info("Car created and saved. Car details: " + car);
		
	}

	@Override
	public void removeCar(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Car car = (Car) session.load(Car.class, new Integer(id));
		
		if(car != null) {
			session.delete(car);
		}
		logger.info("Car has been delete. Delete car details: " + car);		
	}

	@Override
	public void updateCar(Car car) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(car);
		logger.info("Car has been update. Car details: " + car);
	}

	@Override
	public Car getCarById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Car car =(Car)session.load(Car.class, new Integer(id));  
		logger.info("Car successfully get. Car details: " + car);
		return Optional.of(car).orElse(null);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Car> getListCars() {
		
		Session session = sessionFactory.openSession();
		session = this.sessionFactory.getCurrentSession();
		List<Car> carList = session.createQuery("FROM Car").list();
		
		for(Car car : carList) {
			logger.info("Car details: " + car);
		}
		
		return carList;
	}
	
	

}
