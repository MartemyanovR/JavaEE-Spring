package polimorphism;

public class Triangle extends Shape {
	private boolean select;
	@Override
	public void draw() {
		System.out.println("Triangle.draw()");
	}
	@Override
	public void erase() {
		System.out.println("Triangle.erase()");
	}

	public String toString() {
		return "Triangle";
	}	
}
