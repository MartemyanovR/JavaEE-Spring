package exception;

public class ConstructorClassB21 extends ConstructorClassA21{
	
	
	public ConstructorClassB21() throws MyException {
		super("B21");
		try {
			new ConstructorClassA21();
		}catch(MyException e) {
			e.printStackTrace();
		}finally {
			System.out.println("Capture_");
		}
	}
	
	public static void main(String[] args) {
		try {
			ConstructorClassB21 b21 = new ConstructorClassB21();
		} catch (MyException e) {			
			e.printStackTrace();
			System.out.println("In main");			
		}
	}
	
}
