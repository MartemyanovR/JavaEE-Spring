package multithreading.testSpeed;

public class SingleThreadClient {

	public static void main(String[] args) {		
		        Counter counter = new Counter();

		        long start = System.nanoTime();

		        double value = 0;
		        for (int i = 0; i < 400; i++) {
		            value += counter.count(i);
		        }

		        System.out.format("Executed by %d s, value : %f",
		                (System.nanoTime() - start) / (1000_000_000),
		                value);
	}
	
	
	 static class Counter {

	    public Double count(double a) {
	        for (int i = 0; i < 1000000; i++) {
	            a = a + Math.tan(a);
	        }

	        return a;
	    }
	 }

}
