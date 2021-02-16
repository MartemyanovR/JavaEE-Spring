package multithreading.Threads;

public class ExceptionThrreadTest {

	public static void main(String[] args) {
		Thread.UncaughtExceptionHandler h = (th,ex) -> {System.out.println("Uncaught exception: " + ex); };
				
		Thread t = new Thread() {
		    public void run() {
		        System.out.println("Sleeping ...");
		        try {
		            Thread.sleep(1000);
	//	            System.out.println(2/0);
		        } catch (InterruptedException e) {
		            System.out.println("Interrupted.");
		        }
		        System.out.println("Throwing exception ...");
		        throw new RuntimeException();
		    }
		};
	//	t.setUncaughtExceptionHandler(h);
		t.start();
	}

}
