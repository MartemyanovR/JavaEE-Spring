package innerClasses;

public class OuterMain {
	public static void main(String[] args) {
		Outer o = new Outer();
		Outer.Inner i = o.new Inner();
		System.out.println("o.getThis -> " + o.getThis());
		System.out.println("o.getStr  -> " + o.getStr());
		System.out.println("i.getThis -> " + i.getThis());
		System.out.println("i.getStr  -> " + i.getStr());
		Outer.Inner.SuperInner s = i.new SuperInner(i);
		System.out.println("s.getThis -> " + s.getThis());
		System.out.println("s.getStr  -> " + s.getStr());

	}

}
