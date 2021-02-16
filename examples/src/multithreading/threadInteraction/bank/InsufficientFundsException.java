package multithreading.threadInteraction.bank;

public class InsufficientFundsException extends Exception {
	
	public InsufficientFundsException() {
		System.err.println("Insufficient Funds Exception");
	}

}
