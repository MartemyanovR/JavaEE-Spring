package generics;

import java.util.List;

public class TypeInferenceTest {

	public static void main(String[] args) {
		
		List <String> list = TypeInference.nil();
		TypeInference.cons(50, TypeInference.nil());
		TypeInferenceTest.m((Object)TypeInferenceTest.g());  //для 7 и 8разные реализации
		
	}

	 static void m(Object o) {
	       System.out.println("one");
	   }

	   static void m(String[] o) {
	       System.out.println("two");
	   }

	   static <T> T g() {
	       return null;
	   }
}
