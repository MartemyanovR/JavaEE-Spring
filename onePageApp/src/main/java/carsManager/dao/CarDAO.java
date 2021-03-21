package carsManager.dao;

import java.util.List;

import carsManager.model.Car;

public interface CarDAO {
	
	public void addCar(Car car);
	
	public void removeCar(int id);
	
	public void updateCar(Car car);
	
	public Car getCarById(int id);
	
	public List<Car> getListCars();

}
