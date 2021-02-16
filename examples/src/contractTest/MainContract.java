package contractTest;

public class MainContract {
	
	public static void main(String[] args) {
	
		EvenNumericSummator ens = new EvenNumericSummator(new ContractAssert());
		int result = ens.summator(1, 4);
		System.out.println(result);
	}
}
