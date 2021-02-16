package example;

public class OuterClass2 extends OuterInnerClass{			// наследует внешний класс
	
	

	public class InnerClass2 extends Inner{			// наследует внутренний класс другого внешнего класса		
		
		public InnerClass2(String a) {
			super(a);
		}
		public void getOuterInner() {
			super.setJust("Visible for InnerClass2");
		}
		
	}
	
	
}
