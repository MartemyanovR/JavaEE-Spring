package contractTest;

public class PredException extends ContractException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PredException(String s) {
		super("Precondition failed - " + s);
	}

}
