package ru.mart.hibernateAnnotationProject.services;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import ru.mart.hibernateAnnotationProject.dao.CarDao;
import ru.mart.hibernateAnnotationProject.entity.Car;
import ru.mart.hibernateAnnotationProject.utils.SessionUtil;

public class CarService extends SessionUtil implements CarDao{

	@Override
	public void add(Car car) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.save(car);
		closeTransactionSession();;
	}

	@Override
	public List<Car> getAll() throws SQLException {
		String sql = "FROM " + Car.class.getSimpleName();
		openTransactionSession();
		Session session = getSession();
		@SuppressWarnings("unchecked")
		Query<Car> query = session.createQuery(sql);
		List<Car> listCar = query.list();
		closeTransactionSession();
		return listCar;
	}

	@Override
	public Car getById(Long id) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		Car car = session.load(Car.class, id);
		if(car != null) {
			car.toString();
		}
		closeTransactionSession();
		return car;
	}

	@Override
	public void update(Car car) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.update(car);
		closeTransactionSession();		
	}

	@Override
	public void remove(Car car) throws SQLException {
		openTransactionSession();
		Session session = getSession();
		session.remove(car);
		closeTransactionSession();
	}

}
