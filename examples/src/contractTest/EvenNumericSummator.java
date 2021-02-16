package contractTest;

public class EvenNumericSummator {
	final Contract contract;
	
	public EvenNumericSummator(final Contract contract) {
		this.contract = contract;
	}
	
	public int summator(final int a, final int b) {
		contract.requare(a % 2 == 0, "first args is not even");
		contract.requare(b % 2 == 0, "second args is not even");
		final int sum = a + b;
		contract.ensure(sum % 2 == 0, "result is not even");
		contract.ensure(sum == a+b, "result is not equal to expected");
		return sum;
	}
}
