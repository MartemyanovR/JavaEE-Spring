package multithreading.Threads;

public class TestStartThreads1 {

	public static void main(String[] args) {
		Thread thr = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Привет из побочного потока!");
			}
		});
		
		thr.start();
		
		System.out.println("Главный поток завершён...");

	}

}
