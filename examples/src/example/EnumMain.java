package example;

import java.util.Arrays;
import java.util.Collection;

//блох, стр 228

public class EnumMain {

	public static void main(String[] args) {
		double x =  0.2;
		double y = 0.8;
		test(EnumExtendedOperation.class, x,y);
		EnumOperations[] eo = EnumExtendedOperation.class.getEnumConstants();
		testColl(Arrays.asList(eo), x,y);		
	}
	
	private static  <T extends Enum<T> & EnumOperations> void test(Class<T> opEnumType, double x, double y) {
		for (EnumOperations op : opEnumType.getEnumConstants())
			System.out.printf("%.2f %s %.2f = %f%n",x, op, y, op.apply(x, y));
	}
	private static void testColl(Collection<? extends EnumOperations> opSet, double x, double y) {
		for (EnumOperations op : opSet)
			System.out.printf("%.2f %s %.2f = %f%n",x, op, y, op.apply(x, y));
	}

}
