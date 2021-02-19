package multithreading.ekkel.ex_1;

import java.util.concurrent.TimeUnit;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		
		Thread th1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);					
					System.out.println("Start loop");
					int i = 5;
					while((i--)!= 0) {
					System.out.println(i);
					TimeUnit.MILLISECONDS.sleep(500);	
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}				
			}
		});
		th1.start();
		th1.join(5000);  /* здесь главный поток ждет и потом продолжает выполнение*/
		//for(int i = 0; i < 5; i++) {			
		Thread th2 = new Thread(new Ex_1());
		th2.start();
		
		
		
		System.out.println("Waiting for LiftOff");
	}
}
