package exception;



public class SimpleClassTest {
	
	public static void main(String[] args) {
		
		SimpleClass sc = null;
		SimpleClass sc1 = new SimpleClass(20);
		boolean b = true;
		//примитивная модель возобновления
		while(b) {
			try {
				sc1.meth();
				b = false;
			}	
			catch(ArrayIndexOutOfBoundsException e) { 
				System.err.println("error");
				//e.printStackTrace();
			}
		}
		
	}
}
