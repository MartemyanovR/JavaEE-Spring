package contractTest;

public class ContractAssert implements Contract {

	@Override
	public void requare(boolean b, String s) {
		if(!b) throw new PredException(s);		
	}

	@Override
	public void ensure(boolean b, String s) {
		if(!b) throw new PostException(s);		
	}	
}
