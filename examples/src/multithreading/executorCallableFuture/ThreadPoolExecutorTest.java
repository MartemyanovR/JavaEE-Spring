package multithreading.executorCallableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorTest {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		int threadBound = 2;
		ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, threadBound,
	            0L, TimeUnit.SECONDS, new SynchronousQueue<>());
		Callable<String> task = () -> {
			Thread.sleep(1000);
			return Thread.currentThread().getName();
		};
		for (int i = 0; i < threadBound + 1; i++) {
			threadPoolExecutor.submit(task);
		}
		threadPoolExecutor.shutdown();
	}
}
