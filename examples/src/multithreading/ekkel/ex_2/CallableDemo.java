package multithreading.ekkel.ex_2;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableDemo {

	public static void main(String[] args) {
		//ExecutorService exec0 = Executors.newCachedThreadPool();
		ExecutorService exec = Executors.newFixedThreadPool(10);
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for(int i = 0; i < 100; i++) {
			results.add(exec.submit(new TaskWithResult(i))); //метод submit() создает объект Future, параметризованный по конкретному типу результата, возвращаемого Callable.
		}
		for(Future<String> fs : results) 
			try {	
				System.out.println("enter forEach");
				//проверяет, не завершилась ли задача
				while(!fs.isDone()) {
					System.out.println("Task not complete");
					//имитация другой работы
					TimeUnit.MILLISECONDS.sleep(500);
				}
				System.out.println(fs.get());
			} catch(InterruptedException e) {
				System.out.println(e);
				return;
			} catch(ExecutionException e) {
				System.out.println(e);
			} finally {
				exec.shutdown();
			}
	}


}
