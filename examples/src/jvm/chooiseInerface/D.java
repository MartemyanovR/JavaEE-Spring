package jvm.chooiseInerface;

public class D {
	Integer answer;
	
	public void meth(Object obj) {
		System.out.println("D");
	}
	
	public void meth() {
		System.out.println("D2");
		
	}

	public static class I extends D {
		String answer;
		@Override
		public void meth() {
			System.out.println("I");
		}		
	}
	public static class F extends D {
		public void meth() {
			super.meth();
			System.out.println("F");
		}		
	}
	
	public static void main(String[] args) {
			D d = new D();
			I i = new I();
			F f = new F();
			d.meth(new Object());
			i.meth();
			f.meth();
			i.answer = "42";
			System.out.println(i.answer);
					
	}
	

}
