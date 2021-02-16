package genericsHexlet;

import java.util.ArrayList;
import java.util.List;

public class GenericInheritance {

	public static void main(String[] args) {
		List<Number> lnum = new ArrayList<>();
		Integer i = 5;
		Double d = 5d;
		Number n = 0.5;
		Byte b = new Byte((byte) 120);
		lnum.add(n);
		lnum.add(d);
		lnum.add(i);
		lnum.add(b);
		System.out.println(lnum);

	}

}
