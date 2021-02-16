package exception;

public class MyExceptionApp {

	public static void main(String[] args) {
		//
		CheckedMyException cme = new CheckedMyException();
		try {
			cme.checkMeth(-3);
		}
		catch(MyException | MyException2 | MyException3 e) {
			e.printStackTrace();
		}
		try {
			cme.checkMeth(null);
			//после данноq строки выполнение передается блоку finally
			MyException.e();
			
		}
		catch(MyException | MyException2 | MyException3 e) {
			e.printStackTrace();
			System.out.println("This is toString() - " + e);
		}
		finally {
			System.out.println("execution anyway");
		}
	}

}
