package exception;

public class CauseExampleEkkel  {
	public static void f() throws MyException3{
		try {
			System.out.println("This is f()");
			g();
		}
		catch(MyException2 me2) {
			MyException3 me3 = new MyException3("Ошибка MyException3");
			me3.initCause(me2);
			throw me3;
		}
	}
	public static void g() throws MyException2{
		System.out.println("Tis is g()");
		throw new MyException2("Error MyException2");
	}
	
	public static void main(String[] args) {
		try {
			f();
		}
		catch(MyException3 e) {
			System.out.println("Intercepted " + e);
			System.out.println("Cause " + e.getCause());
			System.out.println("\n Stack: ");
		e.printStackTrace();
		}
	}

}
