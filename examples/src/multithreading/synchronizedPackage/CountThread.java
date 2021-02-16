package multithreading.synchronizedPackage;

public class CountThread implements Runnable{
 
    CommonResource res;
    SynchMonitor sm;
    CountThread(CommonResource res, SynchMonitor sm){
        this.res = res;
    	this.sm=sm;
    }
    //???????? + ???????????(??????), ?? ???? ????? ??? ?????? ? ?????? ? ???
    public void run(){
    	synchronized(sm) {
	        res.x=1;
	        for (int i = 1; i < 5; i++){
	            System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
	            res.x++;
	            try{
	                Thread.sleep(100);
	            }
	            catch(InterruptedException e){}
	        }
   		}    
    }
}
