package innerClasses;

public class OuterInheritanceTest {
	public static void main(String[] args) {
		// Примеры наследования внутренних классов и операторов new и super
		
		OuterInheritance out = new OuterInheritance();
		OuterInheritance.Inner01 in01 = out.new Inner01();
		OuterInheritance.Inner01.Inner02 in02 = in01.new Inner02(in01);
		OuterInheritance.Inner01.Inner02 in021 = new OuterInheritance().new Inner01().new Inner02();
		OuterInheritanceExternal outExt = new OuterInheritanceExternal();
		System.out.println(in01.getOutStr());
		System.out.println(in02.getOutStr());
		System.out.println(in02.getStrInn01());
		System.out.println(in01.getStr());
		in01.printStr();
		in02.printStr();
		System.out.println("---------");
		in021.printStr(); 
		//методы работают если переменные не приватные
		//System.out.println(outExt.getOuterStr());
		//System.out.println(outExt.getInnerStr());
		System.out.println(outExt.getInner02Str());
	}

}
