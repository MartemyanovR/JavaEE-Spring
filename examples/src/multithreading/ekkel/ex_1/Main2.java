package multithreading.ekkel.ex_1;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main2  {

	public static void main(String[] args) {
		Runnable task = () -> System.out.println("Task executed");
		Executor executor = (runnable) -> {
			new Thread(runnable).start();
		};
		executor.execute(task);
		
		ExecutorService es = Executors.newSingleThreadExecutor();
		es.execute(task);
		es.shutdown();

	}


}
