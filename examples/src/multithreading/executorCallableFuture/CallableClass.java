package multithreading.executorCallableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class CallableClass implements Callable<String> {

	@Override
	public String call() throws Exception {
		TimeUnit.SECONDS.sleep(2);
		 // наименование потока, выполняющего 
        // callable задачу
		return Thread.currentThread().getName();
	}
	
	public static void main(String[] args) {
		new CallableTest();
	}

}
