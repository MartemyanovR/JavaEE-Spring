package multithreading.Threads;

public class ThreadGroup {

	public static void main(String[] args) {
		Thread currentThread = Thread.currentThread();
		java.lang.ThreadGroup threadGroup = currentThread.getThreadGroup();
		System.out.println("Thread: " + currentThread.getName());
		System.out.println("Thread Group: " + threadGroup.getName());
		System.out.println("Parent Group: " + threadGroup.getParent().getName());
		
		currentThread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Возникла ошибка: " + e.getMessage());
			}
		});
		
		System.out.println(2/0);
	}

}
