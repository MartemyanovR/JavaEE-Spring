package carsManager.service;

import java.util.List;
import carsManager.model.Car;


public interface CarService {
	
	public void addCar(Car car);
	
	public void updateCar(Car car);

	public void removeCar(int id);
	
	public Car getById(int id);
	
	public List<Car> getListCar();
}
