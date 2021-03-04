package multithreading.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

	public static void main(String[] args) {
		
		ReadWriteLockTest readWrite = new ReadWriteLockTest();
		for(int i = 1; i < 6; i++) {
			readWrite.write();		
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		readWrite.read();
		ReadWriteLockTest.stop(readWrite.executor);
		
		
		/*CommonResource common = new CommonResource();
		ReentrantLock locker = new ReentrantLock();	
		
		for (int i = 1; i < 6; i++) {    
			Thread thread = new Thread(new CountThread(common, locker));
				thread.setName("Thread"+ i);
            thread.start();
        }*/

	}

}
