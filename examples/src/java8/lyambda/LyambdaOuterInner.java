package java8.lyambda;

import java.util.function.IntFunction;
import java.util.function.IntFunction;

public class LyambdaOuterInner {
	
	public void prost() {
		System.out.println("outer");
	}
	
	public void func(int i, IntFunction<Integer> intf) {
		if(intf.apply(i) > 0)
			System.out.println("Outer");
	}
	
	public class LyambdaInner {
		
		public void prost() {
			LyambdaOuterInner.this.prost();
			System.out.println("iner");
		}
		
		public void funcIn(int i, IntFunction<Integer> intf) {
			intf.apply(i);	
			System.out.println("inner");
		}		
	}
	
	public static void main(String[] args) {
		LyambdaOuterInner out = new LyambdaOuterInner();
		LyambdaInner in = out.new LyambdaInner();
		int i = 2;
		in.prost();
		in.funcIn(i,
				(x) -> (x + i));
		
		
		
	}

}
