package generics.ekkel.two;

import java.util.ArrayList;

public class TestTwo<T> {
	ArrayList<T> arrl;
	
	public TestTwo() {
		arrl = new ArrayList<T>();
	}
	
	public T get(int i) {
		return arrl.get(i);
	}
	public void set(T t) {
		arrl.add(t);
	}
	@Override
	public String toString() {
		return arrl.toString();
	}
	
	public static void main(String[] args) {
		TestTwo<String> tt = new TestTwo<>();
		tt.set("One");
		tt.set("Two");
		tt.set("Three");
		System.out.println(tt.get(2));
		System.out.println(tt.toString());
		
	
	}
}
