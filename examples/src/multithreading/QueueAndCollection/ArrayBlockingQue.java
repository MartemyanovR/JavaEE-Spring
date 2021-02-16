package multithreading.QueueAndCollection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class ArrayBlockingQue {
	private BlockingQueue<String> bq;
	private final String DONE = "done";
	private final String[]  messages = {
             "Мама пошла готовить обед",
             "Мама позвала к столу",
             "Дети кушают молочную кашу",
             "А что ест папа?"};	
	
	public ArrayBlockingQue() {
		bq = new ArrayBlockingQueue<String>(1);
		new Thread(new Producer()).start();
		new Thread(new Consumer()).start();
	}
	
	class Producer implements Runnable {
		@Override
		public void run() {			
			try {
				int cnt = 0;
				
				for(int i = 0; i < messages.length; i++) {
					bq.put(messages[i]);
					if(++cnt <3)
						TimeUnit.SECONDS.sleep(3);
						
					}
				bq.put(DONE);
			} catch(InterruptedException e) {
				System.err.print(e.getMessage());
			}
		}		
	}
	
	class Consumer implements Runnable {
		@Override
		public void run() {		
			try {				
				String msg = null;
				while(!((msg = bq.take()).equals(DONE)))
					System.out.println(msg);				
			} catch(InterruptedException e) {
				System.err.print(e.getMessage());
			}			
		}		
	}
	
	public static void main(String[] args) {
			new ArrayBlockingQue();
	}

}
