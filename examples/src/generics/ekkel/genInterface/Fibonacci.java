package generics.ekkel.genInterface;

public class Fibonacci implements Generator<Integer> {
	private int count = 0;
	public Integer next() { 
		return fib(count++); }
	
	private int fib(int n) { 
		if(n == 1) return 1;
		if(n == 0) return 0;
		return fib(n-2) + fib(n-1);
	}
	public int fib1(int n) { 
		if(n < 2) return 1;
		return fib1(n-1)+2;
	}
	
	
	public static void main(String[] args) {
	Fibonacci gen = new Fibonacci(); 
	for(int i = 0; i < 18; i++)
		System.out.print(gen.next() + " ");
	System.out.println();
	System.out.println(gen.fib1(6));
	}
	

}
