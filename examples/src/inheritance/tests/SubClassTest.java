package inheritance.tests;

public class SubClassTest extends SuperClassTest {
	private int ii = 1;
	public final int i = 11;
	public static final int SUB_J = 111;
	public static  int sub_nonFinal_J = 111;
	public String subVal = "sub";
	public static String subStaticVal = "SubStatic";
	
	static {System.out.println("Sub static init block");}
	{System.out.println("Init block sub");}
	
	public SubClassTest() {
		System.out.println("Construct Suub");
	}	
	
	public String meth(String str) {
		try {
			System.out.print("Meth sub: " + i + " " + ii + " ");	
			return "sub " + str;
		} finally {
			//System.out.println();			
		}			
	}
	public String meth1(String str) {
		try {
			System.out.print("Meth sub: " + i + " " + ii + " ");	
			return "sub " + str;
		} finally {
			//System.out.println();			
		}			
	}
	
}
