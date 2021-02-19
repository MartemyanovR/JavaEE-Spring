package multithreading.ekkel.ex_2_task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/*
 * Сделайте так чтобы задача была представлена объектом Callable для суммирования значений всех чисел Фибоначчи.
 * Создайте несколько задач и выведите результаты.
 */
public class Main {

	public static void main(String[] args) {
		
		int numberOfExecutions;
		ExecutorService executor = Executors.newFixedThreadPool(3);
		for(numberOfExecutions = 0; numberOfExecutions < 50; numberOfExecutions++) {
			Future<Long> future = executor.submit(new FibonacciTask(numberOfExecutions));			
			try {
				int active = Thread.activeCount();
        		System.out.println(active);
				System.out.println("Fibonacci number from " + numberOfExecutions + " - " + future.get());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}			
		}
		executor.shutdown();		
	}
}
