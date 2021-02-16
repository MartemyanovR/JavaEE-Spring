package multithreading.synch;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

public class ConcurrentHMExample {
	private List<Integer> listI = new CopyOnWriteArrayList<>(); 
	
	private void add() {
		//synchronized (listI) {
		int i = 0;
		System.out.println("Adding:");
		while(i<10) {
			listI.add(i);
			System.out.println("add- " + listI.get(i));		
			i++;
		}
	//	}
	}
	private void delete() {
	//	synchronized (listI) {		
		int i = 5;
		System.out.println("REmoving:");
		while(i>=0) {
			System.out.println("remove- " + listI.get(i) );
			listI.remove(i);			
			i--;
		}
	//	}
	}
	private void iter() {
	//	synchronized (listI) {
		Iterator<Integer> iter = listI.iterator();
		System.out.println("Iterable:");
		while(iter.hasNext())
			System.out.println("Iteration- " + iter.next());		
	}
//	}

	
	public static void main(String[] args) {
		
		ConcurrentHMExample concur = new ConcurrentHMExample();
		
		Thread threadAdd = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					while(true) {
					TimeUnit.MILLISECONDS.sleep(100);
					concur.add(); }
				} catch (InterruptedException e) {
					e.printStackTrace();
				}						
			}
		});
		Thread threadDel = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					while(true) {
					TimeUnit.MILLISECONDS.sleep(150);
					concur.delete();}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});
		Thread threadIter = new Thread( new Runnable() {			
			@Override
			public void run() {
				try {
					while(true) {
					TimeUnit.MILLISECONDS.sleep(150);
					concur.iter();}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}				
			}
		});

		threadAdd.start();
		threadDel.start();
		threadIter.start();
	}

}
