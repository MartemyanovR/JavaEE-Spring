package innerClasses;

import innerClasses.OuterInheritance.Inner01;

public class OuterInheritanceExternal extends OuterInheritance.Inner01.Inner02 {
	public OuterInheritanceExternal() { this(new OuterInheritance().new Inner01().new Inner02()); }
	public OuterInheritanceExternal(OuterInheritance.Inner01.Inner02 o) { o.super(); }
	
	private String str = "External";
	
	
	/*методы работают если переменные не приватные
	String getOuterStr() {
		return this.outstr;
	}
	String getInnerStr() {
		return super.strInn01;
	}   */
	String getInner02Str() {
		return super.strInn02;
	}
}
