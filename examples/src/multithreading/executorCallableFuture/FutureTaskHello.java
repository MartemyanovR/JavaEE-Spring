package multithreading.executorCallableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskHello {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		Callable<String> task = () -> { 
			TimeUnit.MILLISECONDS.sleep(300);
			return Thread.currentThread().getName() + " the end"; };
		
		FutureTask<String> future = new FutureTask<String>(task);

		new Thread(future).start();
		//Как видно из примера, мы получаем при помощи метода get результат из задачи task.
		TimeUnit.MILLISECONDS.sleep(400);
		System.out.println(future.isDone());
		System.out.println(future.isDone());
		
		System.out.println(future.get());
	}

}
