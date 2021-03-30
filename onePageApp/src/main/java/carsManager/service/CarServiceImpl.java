package carsManager.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import carsManager.dao.CarDao;
import carsManager.model.Car;

@Component
public class CarServiceImpl implements CarService {	
	
	private CarDao carDao;	
	
	@Autowired(required = false)
	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	@Transactional
	public void addCar(Car car) {
		carDao.addCar(car);
	}

	@Override
	@Transactional
	public void updateCar(Car car) {
		carDao.updateCar(car);
	}

	@Override
	@Transactional
	public void removeCar(int id) {
		carDao.removeCar(id);
	}

	@Override
	@Transactional
	public Car getById(int id) {
		return carDao.getCarById(id);
	}

	@Override
	@Transactional
	public List<Car> getListCar() {
		return carDao.getListCars();
	}

	
	
}
