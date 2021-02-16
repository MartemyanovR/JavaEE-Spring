package contractTest;

public class PostException extends ContractException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PostException(String s) {
		super("Postcondition failed" + s);
	}

}
