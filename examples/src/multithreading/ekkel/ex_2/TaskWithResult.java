package multithreading.ekkel.ex_2;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TaskWithResult implements Callable<String> {
	
	private int id;
	
	public TaskWithResult(int id) { 
		this.id = id;
	}
	
	public String call() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "result of TaskWithResult " + id;
	}

}
