package innerClasses;

public class ClassCreator {
	
	static ISummator createSummator() {
		// BEGIN (write your solution here)
		ISummator is = new ISummator() {
		public int plus(int a, int b){
			return a + b;
		}
		public int minus(int a, int b){
			return a - b;
		}
		public double div(int a, int b){
			return ((double) a/b);
		}
		public int remDiv(int a, int b){
			return a % b;
		}
		public int mult(int a, int b){
			return a*b;
		}
		public int pow(int a, int b){
		return ((int)Math.pow(a, b));
		}
		// END
		};
		return is;
	}
}
