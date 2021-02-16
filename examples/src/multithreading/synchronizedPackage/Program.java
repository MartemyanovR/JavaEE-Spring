package multithreading.synchronizedPackage;

import java.util.concurrent.TimeUnit;

public class Program {
	public static void main(String[] args) throws InterruptedException {
		SynchMonitor sm = new SynchMonitor();
        CommonResource commonResource= new CommonResource();
        for (int i = 1; i < 6; i++){
             
            Thread t = new Thread(new CountThread(commonResource,sm));
            t.setName("Thread "+ i);
            t.start();
        }
        TimeUnit.SECONDS.sleep(3);
        System.out.println(commonResource.x);
    }

}
