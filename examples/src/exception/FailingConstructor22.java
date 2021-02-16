package exception;

public class FailingConstructor22 {
	final int i;
	private final int result[] = new int[1];
	public FailingConstructor22(final int i) {
		this.i = i;
		
	}
	
	 void divides() throws ArithmeticException {
		result[1] =i/i;
	}

}
