package exception;

public class WhoCalled {	
	static void f() {
		// Генерируем исключение для заполнения трассировки стека 
		try {
			throw new Exception();
		} catch (Exception e) {
			for(StackTraceElement ste : e.getStackTrace()) {
				System.out.print(ste.getLineNumber() + ": ");
			    System.out.println(ste.getMethodName());
				}
			}		
	}
		static void g() { 
			f();
		}		
		static void h() throws Exception{ 		
			try { f();
			} catch(Exception e) {
				System.out.println("B методе h(),e.printStackTrace()");
				e.printStackTrace(System.out);
				throw (Exception)e.fillInStackTrace();
			}
			
			/*	//На вершине стека находится запись о вызове самого метода getStackTrace(),
			//за ним следует запись об имени метода, непосредственно в котором был вызван метод getStackTrace(),
			//в элементе getStackTrace()[i] (i>0) находится имя метода, который вызвал метод,
			//который находится в getStackTrace()[i-1].
			System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
			g(); 		*/
		}
	public static void main(String[] args) throws Exception {
		f();
		System. out .println ("--------------------------------------------------------");
		g();
		System.out .println (".........................................................................") ;
		h();
	}
}