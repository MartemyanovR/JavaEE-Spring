package inheritance.tests;

public class SuperClassTest {
	private int ii = 5;
	public final int i = 55;
	public static final int J = 555;
	public static  int nonFinal_J = 5555;
	public String superVal = "super";
	public static String superStaticVal = "SuperStatic";
	
	static {System.out.println("Static init block" + " " + SubClassTest.SUB_J + " "
			 + nonFinal_J);}
	{System.out.println("Init block");}
	
	public SuperClassTest() {
		System.out.println("Construct Super");
	}
	
	public Object meth(String str) {
		try {
			System.out.print("Meth super " + i);
			return "super" + str;
		} finally {
			System.out.println();
		}		
	}
	
			
			
			
			
			
			
}
