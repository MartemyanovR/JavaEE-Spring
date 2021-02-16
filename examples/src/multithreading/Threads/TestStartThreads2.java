package multithreading.Threads;

public class TestStartThreads2 {
	static AffableThread athread;	
	
	public static void main(String[] args) throws InterruptedException {
		athread = new TestStartThreads2.AffableThread();
		athread.start();
		Thread.sleep(100);
		System.out.println("Главный поток завершён...");

	}
	
	public static class AffableThread extends Thread {

		@Override
		public void run() {
			System.out.println("I'm affable therad");
			System.out.println(getName());
			setName("Strebudan");
			System.out.println(getName());			
		}		
	}

}
