package interfaces;

public interface Interface_A {
	default void print() {
		System.out.println("Interface_A");
	}
	//String meth();
	
	public static void methStat() {
		System.out.println("This is static method ");
	}

}
