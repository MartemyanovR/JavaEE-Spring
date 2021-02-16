package polimorphism;

public class Cycle extends Shape {
	private final int wheel = 0;
	private boolean select = false;
	
	public int getWheels() {
		System.out.println(wheel);
		return wheel;
	}	
	public int wheels() {
				return this.getWheels();
	}	
	@Override
	public void draw() {
		System.out.println("Cycle.draw()");
	}	
	public void erase() {
		System.out.println("Cycle.erase()");
	}	
	public void ride() {
		wheels();
		System.out.println("Cycle.ride()");
	}
	public String toString() {
		return "Cycle";
	}

}
