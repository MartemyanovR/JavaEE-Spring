package java8.linkOfMeth;

public class SuperAndThis {

	public void speak() {
        System.out.println("speak From ConcurrentSuperAndThis");
    }
	
	class ConcurrentSuperAndThis extends SuperAndThis {
	    public void speak() {
	   //При запуске потока вызывается его Runnable, и super::speak выполняется, вызывая speak суперкласса.
	        Thread t = new Thread(super::speak);  
	        //System.out.println("speak From ConcurrentSuperAndThis");
	            t.start();
	        }
	}
	
	public static void main(String[] args) {
		ConcurrentSuperAndThis  c=  new SuperAndThis().new ConcurrentSuperAndThis();
		c.speak();
	}
}
