package contractsEqualsAndHashCode;

import java.util.ArrayList;

public class VialationSymmetryMain {

	public static void main(String[] args) {
		VialationSymmetry vs = new VialationSymmetry("STRING");
		VialationSymmetry vs2 = new VialationSymmetry("string");
		
		System.out.println(vs.equals(vs2));
		System.out.println(vs2.equals(vs));
		String str = new String("string");
		//нарушение принципа симметрии
		System.out.println(vs.equals(str));
		System.out.println(str.equals(vs));
		//checks method "contentEquals"
		StringBuilder sb = new StringBuilder("string");
		System.out.println(str.contentEquals(sb));
		
		ArrayList<VialationSymmetry> arVS = new ArrayList<VialationSymmetry>();
		arVS.add(vs);
		arVS.add(vs2);
		System.out.println();
		//терпим фиаско
		System.out.println(arVS.contains(str));
		
	}

}
