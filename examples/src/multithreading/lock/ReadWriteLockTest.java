package multithreading.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {
	ExecutorService executor = Executors.newFixedThreadPool(2);
	Map<String, String> map = new HashMap<>();
	ReadWriteLock lock = new ReentrantReadWriteLock();	
	
	/*
	 * Поток блокирует ресурсы для записи, после чего ждёт одну секунду, записывает данные в HashMap и освобождает ресурсы.
	 */
	public void write () {
		executor.submit(() -> {
		    lock.writeLock().lock();
		    try {
		        try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		        map.put("foo", "bar");
		    } finally {
		        lock.writeLock().unlock();
		    }
		});
	}
	
	
	/*
	 * Оба потока, созданные для чтения, будут простаивать секунду, ожидая завершения работы потока для записи.
	 *  После снятия блокировки они выполнятся параллельно, и одновременно запишут результат в консоль.
	 *   Им не нужно ждать завершения работы друг друга, потому что выполнять одновременное чтение вполне безопасно
	 *    (до тех пор, пока ни один поток не работает параллельно на запись).
	 */
	public void read() {
		Runnable readTask = () -> {
		    lock.readLock().lock();
		    try {
		        System.out.println(map.get("foo"));
		        try {
					TimeUnit.SECONDS.sleep(2);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    } finally {
		        lock.readLock().unlock();
		    }
		};
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		executor.submit(readTask);
		
		stop(executor);
	}
	
	
	public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(30, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }	
	
}
