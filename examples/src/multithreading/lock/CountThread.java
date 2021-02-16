package multithreading.lock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread implements Runnable{
	CommonResource res; 
	ReentrantLock locker;
	StringBuilder strB=null;
	Path path = Paths.get("c:\\eclipse-workspace\\FFF.txt");
	final String thr3 = "Thread3";
	
	public CountThread(CommonResource res, ReentrantLock locker) {
		this.res = res;
		this.locker = locker;
		
	}
	
	@Override
	public void run() {
		// здесь я нахожу поток, и загружаю его работтой пока не освободится лок
		if(Thread.currentThread().getName().equals(thr3)) {
			System.out.println("Thread-3 caught");
			strB = new StringBuilder();
			while(!locker.tryLock()) {
				for(int i = 0 ; i< 1000000; i++)
					strB.append(i);
				byte[] b = strB.toString().getBytes();
				try {
					Files.write(path, b);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		locker.lock();
		try {
			res.x=1;
            for (int i = 1; i < 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                Thread.sleep(2000);
            }
		} catch(InterruptedException e) {
			e.getMessage();
			e.printStackTrace();
		} finally {
			locker.unlock();
		}
		
	}
}
