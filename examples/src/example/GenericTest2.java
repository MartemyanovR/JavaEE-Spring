package example;

public class GenericTest2 {
	public static void test(Cell c) {
		c.setT("");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cell<X> cell = new Cell<>();
		test(cell);
		X s = cell.getT();
	}

}
class Cell <T> {
	private T t;

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}
