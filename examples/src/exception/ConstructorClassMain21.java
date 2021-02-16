package exception;

public class ConstructorClassMain21 {

	public static void main(String[] args) {
		try {
		FailingConstructor22 fc22 = new FailingConstructor22(1);
			try {
				fc22.divides();
			} catch(ArithmeticException e) {
				System.out.println("Caption, nobody divides by zero");
			}
			finally {
				System.out.println("Close");
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Why do so? Incorrect index");
		}
		
		
		//21
		try {
			new ConstructorClassB21();	
			}catch (Exception e) {
				e.printStackTrace();
			}
	}
	
}
