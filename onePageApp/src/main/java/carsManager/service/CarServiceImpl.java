package carsManager.service;

import java.util.List;

import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import carsManager.dao.CarDAO;
import carsManager.model.Car;

@Service
public class CarServiceImpl implements CarService {
	
	private CarDAO carDao;
	

	public CarServiceImpl() {
	}
	
	public void setCarDao(CarDAO carDao) {
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
