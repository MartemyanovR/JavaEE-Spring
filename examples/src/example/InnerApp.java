package example;

public class InnerApp {
	public static void main(String [] args) {
		OuterInnerClass out = new OuterInnerClass();
		OuterInnerClass.Inner oi =  out.new Inner("1");			// инициализация внутреннего класса
		oi.outer();
		OuterClass2 out2 = new OuterClass2();
		OuterClass2.InnerClass2 oi2 =out2.new InnerClass2("inner2");
		oi2.getOuterInner();
	}

}
