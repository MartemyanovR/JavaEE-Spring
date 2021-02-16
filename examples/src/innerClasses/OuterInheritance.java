package innerClasses;

public class OuterInheritance {
	private String outstr = "Outer";
	private String str = "strOuter00";
	
	String getStr() { return this.str + "_______";}

	class Inner01 extends OuterInheritance {

		private String strInn01 = "strInn01";
		private String str = "strInner01";

		String getOutStr() { return outstr;	}
		// при комментированиии строки вызывается метод суперКласса и возвращается поле суперКласса
		String getStr() { return str + "_________";}

		void printStr() {
			System.out.println("Inner01>" + str);
			System.out.println("Inner01>" + Inner01.super.str);
		}

		class Inner02 extends OuterInheritance.Inner01{
			// без данных конструкторов, также работает
			public Inner02() { this(new OuterInheritance().new Inner01()); }
			public Inner02(OuterInheritance.Inner01 o) { o.super(); }
			private String str = "strInner02";
			public String strInn02 = "strInn02";
			String getOutStr() { return outstr; }

			String getStrInn01() { return strInn01;	}

			void printStr() {
				System.out.println("Inner02>" + str);
				System.out.println("Inner02>" + Inner02.super.str);  //можно использовать super.str
				System.out.println("Inner02>" + Inner01.super.str);
				System.out.println("Inner02>" + Inner01.this.str);    // ссылка на обьект внешнего класса Inner01
				System.out.println("Inner02>" + OuterInheritance.this.str);  // ссылка на обьект внешнего класса OuterInheritance 
			}
		}
	}

	void printStr() { System.out.println(str);	}

}
