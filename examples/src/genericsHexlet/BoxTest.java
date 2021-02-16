package genericsHexlet;

import java.util.ArrayList;
class B extends ArrayList<Integer> {
	
}

public class BoxTest<T> {
	T[] a;
	
	public  T[] meth(T[] a) {
		
		return a;
	}

	public static void main(String[] args) {	
		
		BoxTest<Integer>[] bt = new BoxTest[1];
		bt[0] = new BoxTest();
		Integer[] arrIt = {1,2,3};
		
		
	/*	final BoxHex<Integer> b = new BoxHex<>(12);
		final Integer bFromTheBox = b.getValue();
        System.out.println(bFromTheBox);
        if (bFromTheBox != 12) {
            throw new RuntimeException("Box#getValue() do not returns the value that have been set in the constructor");
        }
        
        final TupleHex<Float, String> th = new TupleHex(25.4F , "massa");
        final Float floatOne = th.getLeft();
        if (floatOne != 25.4F) {
        	throw new RuntimeException("TupleHex#getLeft so not returns the value that have been set in the constructor");
        }
        final String StringOne = th.getRight();
        if (StringOne != "massa") {
        	throw new RuntimeException("Tuple#getRight() do not returns the value that have been set in the constructor");
        }
        System.out.println(th.toString());  */
 	}

}
