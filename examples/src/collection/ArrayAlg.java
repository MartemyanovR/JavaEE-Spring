package collection;

import horstmann.Manager;

public class ArrayAlg  {
	static int x=0;
	public static <T extends Comparable> Pair minmax(T[]a){
		if ((a == null) || (a.length ==0)) return null;
		T min= a[0];
		T max= a[0];
		for(int i=1; i<a.length; i++) {
			if (min.compareTo(a[i])>0) min=a[i];
			if (max.compareTo(a[i])<0) max=a[i];
		}
		return new Pair<> (min,max);
	}
	
	public static  <T> Pair minmax(int a) {
		x = a+10;
		return new Pair();
	}
	public static void minmaxBonus(Manager[] a , Pair <? super Manager> result) {
		
		if ((a == null) || (a.length ==0)) return;
		Manager min = a[0];
		Manager max = a[0];
		
		for (int i= 1 ; i< a.length; i++) {
			if (min.getBonus()> a[i].getBonus()) min=a[i];
			//System.out.println(a[i].getBonus());
			if (max.getBonus()<a[i].getBonus()) max=a[i];
		}
			result.setFirst(min);
			result.setSecond(max);
			//result.getFirst();
		}
		
	}


