package innerClasses;

public class Outer {
	private String str = "Outer";
	private int i = 0;
	private static int j;
	
	static void meth() {
		A a = new A();
		
		j = 3;
		class AB {
			
		}
	//	j = i;
	}

	Object getThis() { return this;	}

	String getStr() { return str; }

	class Inner extends Outer {
		private String str = "Inner";
		String getStr() { return str; }
	

	class SuperInner extends Inner {
		private String str = "SuperInner";
		public SuperInner(Outer.Inner o) {
			o.super(); 
			}
		String getStr() {
			return str + " " + super.str
					+ " " + Outer.this.str;
		}
	  }
	}
}
