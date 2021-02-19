package multithreading.ekkel.ex_1;

import java.util.concurrent.TimeUnit;

public class Ex_1 implements Runnable {
	protected int countDown = 10; // Default
	private static int taskCount = 0;
	private final int id = taskCount++;
	public Ex_1() {}
	public Ex_1(int countDown) {
		this.countDown = countDown;
	}
	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "Liftoff!") + "), ";
	}
	
	public void run() { 
		try {
			while(countDown-- > 0) {
			System.out.print(status());		
			TimeUnit.MILLISECONDS.sleep(100);
			Thread.yield();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
	}

}
