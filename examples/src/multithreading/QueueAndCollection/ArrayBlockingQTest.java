package multithreading.QueueAndCollection;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQTest {
	private static final int MAX_INT = 50;
	private BlockingQueue<Integer> bq;
	private final String DONE = "done";
	int[] arInt = new int[MAX_INT];
	
	public ArrayBlockingQTest() {
		bq = new ArrayBlockingQueue<Integer>(2);
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
	}
	
	class Producer implements Runnable {
		@Override
		public void run() {			
			try {							
				for(int i = 0; i < arInt.length; i++) {
					bq.put(i);
					System.out.println("Put: " + arInt[i]);
					TimeUnit.MILLISECONDS.sleep(new Random().nextInt(300));					
				}
				arInt = null;
			}catch(InterruptedException e) {
				System.err.print(e.getMessage());
			}
		}		
	}
	
	class Consumer implements Runnable {
		@Override
		public void run() {		
			try {			
				int count = 0;
				while(arInt != null || count < MAX_INT - 1) {
					int i =bq.take();
					System.out.println("\t take: " + i);	
					TimeUnit.MILLISECONDS.sleep(new Random().nextInt(300));	
					count++;
				}	
			} catch(InterruptedException e) {
				System.err.print(e.getMessage());
			}			
		}		
	}
	
	public static void main(String[] args) {
		 new ArrayBlockingQTest();
	}

}
