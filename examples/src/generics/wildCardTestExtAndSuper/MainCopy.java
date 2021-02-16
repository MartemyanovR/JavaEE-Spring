package generics.wildCardTestExtAndSuper;

import java.util.ArrayList;
import java.util.List;

public class MainCopy {

	public static void main(String[] args) {
		List<LivingBeings> desc = new ArrayList<>();		
		
		List<LivingBeings> src = new ArrayList<>();
		src.add(new Animal());
		src.add(new Fish());
		src.add(new SawFish());
		src.add(new Lion());
		src.add(new Animal());
		List<Fish> srcFish = new ArrayList<>();
		srcFish.add(new Fish());
		srcFish.add(new SawFish());
		List<Feline> srcFel = new ArrayList<>();
		srcFel.add(new Lion());
		srcFel.add(new Feline());
				
		copy(desc,src);
		copy(desc,srcFish);
		copy(desc,srcFel);
		System.out.println(desc.size());
	//	copy(srcFish,desc);  /no
	}
	
	public static <T> void copy(List<? super T> dest, List<? extends T> src) {
		for(T t : src) 
			dest.add(t);	
		
		//можно так
/*		for(int i = 0;  i <src.size(); i++)
		dest.add(src.get(i));	*/  		
		
		}

}
