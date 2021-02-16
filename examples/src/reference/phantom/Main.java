package reference.phantom;

import java.lang.ref.*;

public class Main {

   public static void main(String[] args) throws InterruptedException {
       Thread.sleep(10000);

       ReferenceQueue<TestClass> queue = new ReferenceQueue<>();
       Reference<TestClass> ref = new MyPhantomReference<>(new TestClass(), queue);
       Thread.sleep(50);
       System.out.println("ref = " + ref);

       Thread.sleep(5000);

       System.out.println("Вызывается сборка мусора!");

       System.gc();
       Thread.sleep(300);

       System.out.println("ref = " + ref);

       Thread.sleep(5000);

       System.out.println("Вызывается сборка мусора!");

       System.gc();
   }
}
