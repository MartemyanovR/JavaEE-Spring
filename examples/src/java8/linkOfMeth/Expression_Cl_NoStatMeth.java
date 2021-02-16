package java8.linkOfMeth;

public class Expression_Cl_NoStatMeth {
	
	interface Expres<T>{
		abstract String meth(T t);
	}
	
	static class ExpressExtends {
		
		 String methToString(ExpressExtends ex) {		        
		     return ex.toString();			 
		    }
	}
	
	static String methStat(String str, Expres<ExpressExtends> ex) {
		return str + " " + ex;
	}
	
	public static void main(String[] args) {
//		System.out.println(methStat("It is object: ",ExpressExtends::methToString));
		
		Runnable sleepingRunner = () -> { System.out.println("…"); try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} };
	}

}
