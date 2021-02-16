package multithreading.threadInteraction.bank;

public class Operations {

	public static void main(String[] args) {
			final Account a = new Account(1000);
			final Account b = new Account(2000);
			for(int i = 0; i < 10; i++) {
				new Thread(() -> { 
					try {
						transfer(a,b,500);
					} catch (InsufficientFundsException |InterruptedException e) {
						e.getMessage();
					} 
				}).start();
				
				new Thread(() -> { 
					try {
						transfer(b,a,500);
					} catch (InsufficientFundsException |InterruptedException e) {
						e.getMessage();
					}
				}).start();
			}
	}
	
	public static void transfer(Account acc1, Account acc2, int amount)
													throws InsufficientFundsException, InterruptedException {
		if(acc1.getBalance() < amount) 
			throw new InsufficientFundsException();		
		synchronized (acc1) {
			System.out.println("Lock by " + acc1);
			Thread.sleep(100);
			synchronized (acc2) {
				System.out.println("Lock by " + acc2);
				acc1.withDraw(amount);
				acc2.deposit(amount);
			}
		}
		System.out.println("operation successful! " + "Balance sender: " + acc1.getBalance() + ". Balance sender: " + acc2.getBalance());
	}
	
}
