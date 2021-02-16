package multithreading.Threads;

public class DisputeThreads {
	static EggVoice egg;
	
	public static void main(String[] args) {
		egg = new EggVoice();
		System.out.println("Start dispute");
		egg.start();
		for(int i = 0; i <5 ; i++) {
			try {
				Thread.sleep(1000);
				System.out.println("Chicken");
			} catch(InterruptedException e) {
				e.getMessage();
			}
		}				
		
			if (egg.isAlive()) {
				try{
					egg.join();		
				} catch(InterruptedException e) {
					e.getMessage();
				}
			System.out.println("First egg");
			}
			else
				System.out.println("First Chicken");
		
			System.out.println("Dispute end");
		
	}

	public static class EggVoice extends Thread {
		@Override
		public void run() {
			for(int i = 0; i <5 ; i++) {
				try {
					sleep(1000);
					System.out.println("Egg");
				}
				catch(InterruptedException e) {
					e.getMessage();
				}
			}
		}		
	}
}
