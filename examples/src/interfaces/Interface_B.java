package interfaces;

public interface Interface_B  {
	default void print() {
		System.out.println("Interface_B");
		
	}
	default Object meth() {
		System.out.println("meth interface");
		return null;
	}
}
