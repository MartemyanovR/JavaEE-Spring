package collection;

import java.util.*;

public class NullKeyMapAndSet {
	
	private static class StatCl {
		private int k = 0;
		private static int s = 0;
		
		private static void methStat(final int i) {
			s += i;
			System.out.println(s);
			}
	}

	public static void main(String[] args) {
		
		
		
		NullKeyMapAndSet.StatCl sc = new NullKeyMapAndSet.StatCl();
		NullKeyMapAndSet.StatCl.methStat(5);
		
		Map<Integer,String> mapInt = new HashMap<>();
		mapInt.put(null, null);
		mapInt.put(0, "0");
		mapInt.put(0, "0");
		mapInt.put(1, "1");
		mapInt.put(2, "2");
		mapInt.put(2, "4");
		mapInt.put(null, "33");
		System.out.println(mapInt.toString());
		Iterator it = mapInt.entrySet().iterator();
		while(it.hasNext())
			System.out.println(it.next());
		
		Map<Integer,String> map = new TreeMap<>(); 
	//	map.put(null, "0");  //не используется в 3мар
		map.put(0, "a");
		map.put(1, "b");
		map.put(2, "c");
		System.out.println(map.size());
		//System.out.println(map.toString());
	}

}
