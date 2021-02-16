package multithreading.threadInteraction.bank;

public class Account {
	private int balance;
	
	public Account(int balance) {
		this.balance = balance;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public void withDraw(int amount) {
		balance-= amount;
	}
	public void deposit(int amount) {
		balance += amount;
	}
}
