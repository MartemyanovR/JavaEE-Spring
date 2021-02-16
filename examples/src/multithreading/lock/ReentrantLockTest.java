package multithreading.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public static void main(String[] args) {
		
		CommonResource common = new CommonResource();
		ReentrantLock locker = new ReentrantLock();	
		
		for (int i = 1; i < 6; i++) {    
			Thread thread = new Thread(new CountThread(common, locker));
				thread.setName("Thread"+ i);
            thread.start();
        }

	}

}
