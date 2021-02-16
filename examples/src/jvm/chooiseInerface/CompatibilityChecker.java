package jvm.chooiseInerface;

public class CompatibilityChecker {
	 public String foo(A a) {
	        return "A";
	    }

	    public String foo(B b) {
	        return "B";
	    }

	    public static void main(String[] args) {
	        CompatibilityChecker checker = new CompatibilityChecker();
//	        System.out.println(checker.foo(new C()));  //через cmd при отдельной загрузке класса А, компилируется с выводом А 
	    }

}
