package contractTest;

public class ContractException extends Error {
	
	static final String assertInfo = "Violation contract \n";
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		public ContractException(String s) {
		
			super(assertInfo + s);
		}
	
	
}
