package reference.phantom;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
/*
 * Далее нам понадобится класс, который будет наследоваться от PhantomReference. 
 * Зачем нам нужен такой класс?
 * Все просто. Так мы сможем добавить дополнительную логику к методу clear(), 
 * чтобы увидеть, что очистка фантомной ссылки действительно произошла (а значит, объект удален).
 */

public class MyPhantomReference<TestClass> extends PhantomReference<TestClass> {
	
   public MyPhantomReference(TestClass obj, ReferenceQueue<TestClass> queue) {
       super(obj, queue);
       Thread thread = new QueueReadingThread<TestClass>(queue);
       thread.start();
   }

   public void cleanup() {
       System.out.println("Очистка фантомной ссылки! Удаление объекта из памяти!");
       clear();
   }
}