package multithreading.measurement;

public class Meas1 {

	public static void main(String[] args) throws InterruptedException {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 2000; i++)
		Thread.sleep(2);
		long end = System.currentTimeMillis();
		System.out.println("Millis elapsed: "+ end + "- " + start + " = " +  (end - start) / 4000.0);
		/*общее затраченное
		кодом время дает нам некоторое представление о накладных расходах на
		планирование типичного процесса, т.е. примерно 30% уходит на планировщик*/
	}
	
}
