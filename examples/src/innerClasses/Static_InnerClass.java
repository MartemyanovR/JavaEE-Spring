package innerClasses;

import java.util.Random;

public class Static_InnerClass {
	
	private static int min_val = Integer.MAX_VALUE;
	private static int max_val = Integer.MIN_VALUE;
	
	//статический класс применяется в случае когда доступ к обьекту внутренего класса не требуется
	public static class InnerStat {
		
		private  final int min ;
		private final int max;
		
		public InnerStat (final int min, final int max) {
			
			this.min = min;
			this.max = max;
		}		
		public void showResult() {
			System.out.println("min =" + min + " Max =" + max);
		}
		public static void OutShow (Static_InnerClass s) {
			s.hidenOutMethod();
		}
	}
	
	// если класс InnerStat сделать НЕ статическим, то статический метод minMax не сможет 
	//вернуть обект класса InnerStat, тк при инициализации внутреннего класса,
	//обьект внешнего класса Static_InnerClass недоступен!
	
	public static InnerStat minMax() {
		Random ran = new Random();
		int bound = 100;
		int value = 0;
		int count = bound;
		while(count-- > 0) {
			value = ran.nextInt(bound);
			if (value < min_val) min_val = value; 
			if (value > max_val) max_val = value; 
			}
		return new InnerStat(min_val, max_val );
	}
	
	//закрытый метод. Доступ через статический метод вложеного класса
	private void hidenOutMethod() {
		System.out.println("This is method in the Static_InnerClass");
	}

}
