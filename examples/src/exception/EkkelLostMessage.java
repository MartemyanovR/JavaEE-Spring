package exception;

public class EkkelLostMessage {
	public static void f() throws MyException2{
		throw new MyException2();
	}
	public static void g() throws MyException3 {
		throw new MyException3();
	}	
	public static void h() throws MyException4 {
		throw new MyException4();
	}
	public static void main(String[] args) {
		try {
			EkkelLostMessage elm = new EkkelLostMessage();
			try {
				elm.f();
			}
			finally {		
				try {
					elm.g();
				}
				finally {
					elm.h();
				}
			}
		} catch (Exception e) {
			System.out.println("Dont execute");
			e.printStackTrace();
		}
		
	}
}
