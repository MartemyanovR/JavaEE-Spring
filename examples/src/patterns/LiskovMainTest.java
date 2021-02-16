package patterns;

public class LiskovMainTest {
	static LiskovSquare getRect() {
		return new LiskovSquare();
		}
	
	public static void main(String[] args) {
		LiskovSquare rect  = getRect();
		LiskovSquare square = getRect();
		rect.setWidth(10);
		//rect.setHeight(5);
		System.out.println(rect.getSquare());

		
	}

}
