package java8.lyambda;

public class LyambdaApp {
	
	interface Operationable {
		int calculate(int x,int y);
	}
	
	interface Printable{
	    void print(String s);
	}
	
	interface OperationGen<T>{
		    T calculate(T x, T y);
		}

	interface OperationGen1<K>{
	  <T>  K calculate(T x, T y);
	}
	public static void main(String[] args) {
		
		Operationable operation;
		//лямбда возвращает обьект анонимного сласса
		//параметры лямбда-выражения соответствуют параметрам единственного метода интерфейса 
		operation = (x,y) -> x+y;
		//а это вызов метода из функционального интерфейса
		int res = operation.calculate(5, 5);
		System.out.println(res);
		
		Printable printable = (s) -> System.out.println();
		printable.print("Hello");
		
		OperationGen<Integer> og = (x,y) -> x+y;
		og.calculate(0, 2);
		
		OperationGen1<Boolean> og1 = new OperationGen1<Boolean>() {
			@Override
			public <T> Boolean calculate(T x, T y) {	
				if(true)
					return true;
				return false;
			}			
		};
		og1.<Integer>calculate(5, 6);
	}

}
