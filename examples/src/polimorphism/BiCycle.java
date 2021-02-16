package polimorphism;

public class BiCycle extends Cycle  {
	private final int two = 2;
	
	public int getWheels() {
		System.out.println(two);
		return two;
	}


	public void ride() {
		super.wheels();
		System.out.println("Two wheels");
	}

}
