package carsManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import carsManager.model.Car;
import carsManager.service.CarService;
import carsManager.service.CarServiceImpl;

@Controller
@RequestMapping
public class CarController {
	
	private CarServiceImpl carService;	
	
	@Autowired(required = true)
	public void setCarService(@Qualifier(value="carService") CarServiceImpl carService) {
		this.carService = carService;
	}

	//приветствие
	@GetMapping("/greeting")
	public String greeting( Model model) {
	
		return "index";
	}	
	
	@GetMapping
	public String listCars(Model model) {
		model.addAttribute("cars", carService.getListCar());
	
		return "cars";
	}
	
	@PostMapping("/add")
	public String addCar(@ModelAttribute("Car") Car car) {
		if(car.getId() == 0) {
			carService.addCar(car);
		} else {
			carService.updateCar(car);
		}				
		
		return "redirect:/cars";
	}
	
	@GetMapping("remove/{id}")
	public String removeCar(@PathVariable("id") int id) {
		carService.removeCar(id);
		
		return "redirect:/cars";
	}
	
	@PostMapping("/edit/{id}")
	public String updateCar(@ModelAttribute("Car") Car car, @PathVariable("id") int id) {
		car.setId(id);
		carService.updateCar(car);
		
		return "redirect:/cars";
	}
	
	@GetMapping("/show/{id}")
	public String getCar(@PathVariable("id") int id, Model model) {
		model.addAttribute("car", carService.getById(id));
		return "show";
	}
	
	
	
	
}
