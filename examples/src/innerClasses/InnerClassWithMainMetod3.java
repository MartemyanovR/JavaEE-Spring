package innerClasses;

public class InnerClassWithMainMetod3 {
	
	
	public InnerClassWithMainMetod3() {
		this.new InnerMain2().meth();
	}
	
	public static class Inner {
		/**
		 * Если вы избавитесь от статики, то сможете присвоить ей значение в конструкторе,
		 *  так как каждый раз это новая переменная.
		 *   Если вы избавитесь от final, то это будет просто статическая переменная,
		 *    которой вы можете присвоить новое значение в любое время.
		 */
		final int j;
		
		static {
			
		}
		
		Inner() {
			j = 5;
			
		}
		
		
		
	}
	
	 
	interface Inter {
		static int i = 1;
		void l();
		
	}
	
	
	public static void meth() {
		//static int i = 5;
		System.out.println("Start with outer class");
		
		
		class innerLocalClass {
			public String str;
			
			innerLocalClass(String str) {
				this.str = str;
			}
		}
		
	}
	
	class InnerMain2 
		//StackOverflowError in this case extends InnerClassWithMainMetod3 
			{
		//dont compite
	//	static int i = 5;
		static final int j = 5;
		
		public void meth() {
			System.out.println("Start with inner class");
		}
		/*
	// cant start static method from notStatic class	
		public static void main(String args[]) {
			new InnerClassWithMainMethod.InnerMain().meth();
		}
		*/
	}
	

}


