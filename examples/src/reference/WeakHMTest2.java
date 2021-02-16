package reference;

import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;

public class WeakHMTest2 {

	private static Map<Integer,String> whm;
	private static String str = new String("Go");
	
	public static void main(String[] args) {	
		String str2 = str;
		System.out.println(str + " " + str2);
		Integer in = new Integer(1);
			
			whm = new WeakHashMap<Integer, String>();
			whm.put(in, str);
			
			Thread th = new Thread(new Runnable() {
				
				@Override
				public void run() {
					while(whm.containsKey(1))  {
						try {
							System.out.println("Weak Alive");
							TimeUnit.MILLISECONDS.sleep(10);
						}catch(InterruptedException e){
							e.printStackTrace();
						}
					}
					System.out.println("Weak delete");
				}
			});
			th.start();
			System.out.println(str + " " + str2 + " " +  whm.get(in));
			while(th.isAlive()) {
				Integer ig=0;
				for(int i = 0; i<100000; i++) {
					for(int i1 = 0; i<100000; i++) 
						for(int i2 = 0; i<100000; i++) 
							for(int i3 = 0; i<1000000; i++) 
								 ig++;			
				}
			}
			System.out.println("End task");	
			//как только мы обращаемся к обьекту который лежит в хэш мап извне, либо же jvm видит что есть необработанное обращение
			//то обьект не очищается gc 
	}
	
}
