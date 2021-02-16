package generics.ekkel.genericMethod;

import java.util.HashMap;
import java.util.Map;

public class InvokeMethInMeth {
	public static <K,V> Map<K,V> createMap() {
		System.out.println("Create");
		return  new HashMap<K,V>();
	}
	
	public static <K,V> void f (Map<K,V> map) {
		System.out.println("Work");
	}
	
	public static void g (Map<String,Integer> map) {
		System.out.println("Work_g");
	}
	

	public static void main(String[] args) {
		
		InvokeMethInMeth.f(new HashMap<String,Integer>());
		InvokeMethInMeth.f(InvokeMethInMeth.createMap());
		InvokeMethInMeth.g(InvokeMethInMeth.createMap());
	}

}
