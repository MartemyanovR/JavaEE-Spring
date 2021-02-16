package polimorphism;

public class UniCycle extends Cycle {
	private final int one = 1;
	
	public int getWheels() {
		System.out.println(one);
		return one;
	}
	public int wheels() {
		System.out.println("excute");
		return 100500;
	}
	
	public void ride() {
		super.wheels();
		System.out.println("One wheel");
	}
	

}
