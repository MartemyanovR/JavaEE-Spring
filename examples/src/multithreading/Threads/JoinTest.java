package multithreading.Threads;

public class JoinTest extends Thread{
	int x = 2;
	
	public static void main (String[] args) throws InterruptedException {
		JoinTest th = new JoinTest();
		th.make();
	}
	
	public JoinTest() {
		x= 5;
		start();
	}
	
	public void make() throws InterruptedException {
		this.join();
		x = x-1;
		System.out.println(x);
	}
	
	public void run() {
		x *= 2;
		System.out.println(x + " in run");
	}

}
