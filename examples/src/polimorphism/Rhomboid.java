package polimorphism;

public class Rhomboid extends Shape {
	private boolean select;
	@Override
	public void draw() {
		System.out.println("draw.Rhomboid");
	}
	public String toString() {
		return "Rhomboid";
	}
}
