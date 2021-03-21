package carsManager.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CARS")
public class Car {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "MODEL")
	private String model;
	
	@Column(name = "CARBODY")
	private String carBody;
	
	@Column(name = "PRICE")
	private int price ;
	

	public Car() {		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getCarBody() {
		return carBody;
	}
	public void setCarBody(String carBody) {
		this.carBody = carBody;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "Car [id=" + id + ", model=" + model + ", carBody=" + carBody + ", price=" + price + "]";
	}
	

}
