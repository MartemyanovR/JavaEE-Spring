package polimorphism;

public class Square extends Shape{
	private boolean select;

	@Override
	public void draw() {
		System.out.println("Square.draw()");
	}

	@Override
	public void erase() {
		System.out.println("Square.erase()");
	}
	
	public String toString() {
		if (super.getSelect())
			return "Square highLight";
		return "Square";
	}
		 

}
