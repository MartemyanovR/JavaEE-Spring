package multithreading.threadInteraction.livelockDetected;

public class Livelock {

	public static void main(String[] args) {
		final Worker worker1 = new Worker("Worker1", true);
		final Worker worker2 = new Worker("Worker2", true);
		final CommonResource comonResource = new CommonResource(worker1);
		
		new Thread(() -> {
			worker1.work(comonResource, worker2);
		}).start();
		new Thread(() -> {
			worker2.work(comonResource, worker1);
		}).start();
		

	}

}
