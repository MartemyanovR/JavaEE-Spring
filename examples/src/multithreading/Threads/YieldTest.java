package multithreading.Threads;

public class YieldTest extends Thread {

	public static void main(String[] args) {
		/*Runnable r = () -> {
            int counter = 0;
            while (counter < 20) {
                System.out.println(Thread.currentThread()
                    .getName());
                counter++;
               // Thread.yield();
            }
        };
        new Thread(r).start();*/
        new YieldTest().start();
    }
	
}

