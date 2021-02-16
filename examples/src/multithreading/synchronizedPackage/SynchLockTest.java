package multithreading.synchronizedPackage;

import java.util.concurrent.TimeUnit;

public class SynchLockTest {
	
	static class A {
		public synchronized void meth(B b) throws InterruptedException {			
			System.out.println("In meth A");
			b.meth1(this);
			TimeUnit.SECONDS.sleep(10);
			}
	}
	static class B {
		public synchronized void meth1(A a) throws InterruptedException {
			C c = new C();
			System.out.println("In meth B");
			c.meth2(this);
			TimeUnit.SECONDS.sleep(10);
		}
	}
	static class C{
		public synchronized void meth2(B b) throws InterruptedException {
			System.out.println("In meth C");
			TimeUnit.SECONDS.sleep(10);
		}
	}
	
		
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		new Thread(() -> {
			try {
				a.meth(b);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		new Thread(() -> {
			try {
				a.meth(b);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
		
	}

}
