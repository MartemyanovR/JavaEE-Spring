package multithreading.ekkel.ex_2_task;

import java.util.concurrent.Callable;

public class FibonacciTask implements Callable<Long> {

	private long id;
	
	public FibonacciTask(long id) { 
		this.id = id;		
	}
	
	public Long call() {
		long result = 0;
		result = fib(id);
		return result;
	}
	
	public long fib(long n) {
		if(n == 1)
			return 1;
		if(n == 0)
			return 0;
		return fib(n-1) + fib(n-2);		
	}
	
	
	

}
