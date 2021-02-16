package multithreading.atomicPackage;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
	private static int value = 0;
	private static AtomicInteger atomicInt = new AtomicInteger(0);

	public static void main(String[] args) throws InterruptedException {
		
		Runnable task = () -> {
			for(int i = 0; i < 100000; i++) {
				value++;
				atomicInt.incrementAndGet();
			}
		};
		
		for (int i = 0; i < 3; i++) {
            new Thread(task).start();
		}
        Thread.sleep(300);
        System.out.println(value);
        System.out.println(atomicInt.get());
		

	}

}
