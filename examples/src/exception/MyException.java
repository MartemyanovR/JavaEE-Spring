package exception;

public class MyException extends Exception{
	public MyException() {}
	public MyException(String msg) {super(msg);} 
	
	public static void e() throws MyException {
		System.out.println("!!!");
		throw new MyException("Create in e()");
	}
	
	public static void main(String[] args) {
		try {
			e();
		}		
		finally {
			System.out.println("Ahtung");
			return;
		}
		/*
		catch(MyException e) {
			e.printStackTrace();
		}
		System.out.println("After exception");
		*/
	}

}
