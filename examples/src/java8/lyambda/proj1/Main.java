package java8.lyambda.proj1;

public class Main {

	public static void main(String[] args) {
		Car1 c1 = new Car1(4,"Red",Form.SEDAN);
		Car car = new Car(4,"Green", Form.LIFTBACK);
		
		double len = c1.length(Form.SEDAN,
				() -> (c1.getColor() == "Red") ? true : false);
		
		System.out.println(len);
		
		c1.widht(car,
				Form.SEDAN,
				() -> (car.getColor() == "Green"),
				(c) -> car.info()
				);				
	}

}
