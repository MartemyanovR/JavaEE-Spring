package multithreading.executorCallableFuture;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServiceTest {

	public static void main(String[] args) {
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(4);
		Runnable task = () -> {
			System.out.println(Thread.currentThread().getName());
		};
		scheduledExecutorService.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

	}

}
