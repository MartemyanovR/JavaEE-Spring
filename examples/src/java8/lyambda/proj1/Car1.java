package java8.lyambda.proj1;

import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Predicate;;

public class Car1  {
	private Form form;
	private String color;
	private int wheel;
	
	
	public Car1(int wheel, String color, Form form) {
		this.form = form;	
		this.color = color;	
		this.wheel = wheel;	
	}
	
	public Form getForm() {
		return form;
	}

	public String getColor() {
		return color;
	}

	public int getWheel() {
		return wheel;
	}	
	
	public String filter() {
		CarFilter cf = new CarFilter() {			
			@Override
			public boolean carFilter() {
				return color == "Red" ? true : false;
			}
		};		
		return cf.carFilter() == true ? "Red" : "another color"; 
	}
/*	
 *use own interface
	public double length(Form form, CarFilter filter) {
		if(filter.carFilter() == true)
			return form.getSize() * wheel;
		return 0;
	}
*/		
//   use function interace BooleanSupplier
	public double length(Form form, BooleanSupplier bs) {
		if(bs.getAsBoolean() == true)
			return form.getSize() * wheel;
		return 0;
	}
	
	public void widht(Car car,Form form, BooleanSupplier bs, Consumer<Car> cc) {		
		if(bs.getAsBoolean() == true) {
			cc.accept(car);
			}		
		
	}

}
