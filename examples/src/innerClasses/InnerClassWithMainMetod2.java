package innerClasses;

public abstract class InnerClassWithMainMetod2 {
	
	abstract void meth();
	
	static class InnerMain2 implements InnerClassWithMainMethod {
		
		public void meth() {
			System.out.println("Start!");
		}
		
		public static void main(String args[]) {
			new InnerClassWithMainMethod.InnerMain().meth();
		}
	}
	

}
