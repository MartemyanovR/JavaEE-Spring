package exception;

public class AssertTest {

	public static void main(String[] args) {		
		try {
	    String one = assertMeth("_");
		assert one != "_";
		System.out.println(one);
		}
		catch(AssertionError e) {
			e.printStackTrace();
		}
		
	}

	private static String assertMeth(String s) {
		return s;
	}
}
