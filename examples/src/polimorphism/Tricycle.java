package polimorphism;

public class Tricycle extends Cycle  {
	private final int three = 3;
	
	public int getWheels() {
		System.out.println(three);
		return three;
	}

	public void ride() {
		super.wheels();
		System.out.println("Tricycle");
	}

}
