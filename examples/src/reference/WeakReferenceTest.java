package reference;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

public class WeakReferenceTest {

	public static void main(String[] args) {
	/*	Map<Weak,Integer> mapw = new WeakHashMap<Weak, Integer>();
		Weak w = new Weak("Hello");
		mapw.put(w, 5);
		System.out.println(mapw);
		w = null;
		System.out.println(mapw);
		System.gc();
		System.out.println(mapw);*/
		
		//работает только если gc видит что обьект более не используется
	weakTest();
	}
		
		public static String weakTest() {
		Weak w1 = new Weak("Hi");
		Weak w2 = new Weak("Hi");
		WeakHashMap<Weak, Integer> whm = new WeakHashMap<Weak, Integer>();
		whm.put(w2, 1);
		WeakReference<Weak> wr = new WeakReference<>(w1);
	//	w1 = null;	
		Integer ig=0;
		for(int i = 0; i<100000; i++) {
			for(int i1 = 0; i<100000; i++) 
				for(int i2 = 0; i<100000; i++) 
					for(int i3 = 0; i<1000000; i++) 
						 ig++;
		}
	//	System.gc();
		Weak weak = wr.get();
		Integer intWeak = whm.get(w2);
		System.out.println(weak);
		System.out.println(intWeak);
		//System.out.println(Arrays.toString(arw));  
		if (weak == null)
			return "null";
		return weak.toString();
		}
}
