package multithreading.synch;

import java.lang.invoke.VolatileCallSite;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class TestLatch {
	volatile int i1= 5;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread();
		TestLatch tl = new TestLatch();
		tl.timeTasks(5, t);
	}
	
	public void timeTasks(int nThreads, final Runnable task) throws InterruptedException{
		
		CountDownLatch start = new CountDownLatch(1);
		CountDownLatch end = new CountDownLatch(nThreads);
		
		for(int i = 0; i < nThreads; i++) {
			Thread th = new Thread() {
				public void run() {
					try {
						System.out.println("currrent thread " + Thread.currentThread());
						//здесь все потоки ждут вызова start.countDown
						start.await();
						System.out.println("currrent thread " + Thread.currentThread() + " afterWait");
						
					//  я пока не знаю для чего этот код
						/*	try {
							task.run();
							System.out.println("currrent thread " + Thread.currentThread() + " after run");
						} finally {
							System.out.println("currrent thread " + Thread.currentThread() + " before end.countDown");
							end.countDown();							
						}  */
						//каждый поток уменьшает счетчик на 1
						end.countDown();
						System.out.println(--i1);
					} catch(InterruptedException e) {
						System.err.println(e.getMessage());
					}
				}
			};			
			th.start();
		}
		
		
		
		TimeUnit.SECONDS.sleep(1);
		System.out.println();
		
		//даем старт для работы всех потоков
		start.countDown();	
		TimeUnit.SECONDS.sleep(1);
		
		//основной поток ждет пока пока счетчик по end станет 0
		end.await();
		System.out.println();
			
		System.out.println("currrent thread " + Thread.currentThread() + " END");
				
	}

}
