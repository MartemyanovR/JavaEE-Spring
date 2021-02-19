package multithreading.testSpeed;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

import multithreading.testSpeed.SingleThreadClient.Counter;
import multithreading.threadPool.ThreadPool;

public class MultithreadClient {

	public static void main(String[] args) throws ExecutionException, InterruptedException {
		
		//ThreadPool threadPool = new ThreadPool(5);
		ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Counter counter = new Counter();

        long start = System.nanoTime();

        List<Future<Double>> futures = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            final int j = i;
            futures.add(
                    CompletableFuture.supplyAsync(
                            () -> counter.count(j),
                            threadPool
                    ));
        }

        double value = 0;
        for (Future<Double> future : futures) {
            value += future.get();
        }

        System.out.format("Executed by %d s, value : %f",
                (System.nanoTime() - start) / (1000_000_000),
                value);

        threadPool.shutdown();
    }
	
}
