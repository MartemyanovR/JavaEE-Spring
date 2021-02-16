package genericsHexlet;

public class TupleHex<T1,T2> {
	private final T1 left;
	private final T2 right;
	
	public TupleHex (T1 left, T2 right) {
		this.left = left;
		this.right = right;
	}
	public T1 getLeft() {
		return left;
	}
	public T2 getRight() {
		return right;
	}
	public String toString() {
		return this.getLeft()+ "kg " + this.getRight();
	}

}
