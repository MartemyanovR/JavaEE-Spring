package polimorphism;

public class Shape {
	private boolean select;

	public void draw() {System.out.println("Shape");}
	public void erase() {}
	public boolean isSelect() {
		select = true;
		return true	;
	}
	public boolean getSelect() {
		if (select) return true;
		return false;
	}
}
