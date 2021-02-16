package reference.phantom;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
/*
 * Далее, нам понадобится отдельный поток, который будет ждать, 
 * пока сборщик мусора сделает свое дело, и в нашей очереди ReferenceQueue появятся фантомные ссылки.
 *  Как только такая ссылка попадет в очередь, у нее будет вызван метод cleanup():
 */

public class QueueReadingThread<TestClass> extends Thread {
   private ReferenceQueue<TestClass> referenceQueue;

   public QueueReadingThread(ReferenceQueue<TestClass> referenceQueue) {
       this.referenceQueue = referenceQueue;
   }

   @Override
   public void run() {
       System.out.println("Поток, отслеживающий очередь, стартовал!");
       Reference<TestClass> ref = null;       
//ждем, пока в очереди появятся ссылки
       while ((ref = (Reference<TestClass>) referenceQueue.poll()) == null) {
           try {
               Thread.sleep(50);
               System.out.println("1");
           }
           catch (InterruptedException e) {
               throw new RuntimeException("Поток " + getName() + " был прерван!");
           }
       }       
//как только в очереди появилась фантомная ссылка - очистить ее
       ((MyPhantomReference<TestClass>)ref).cleanup();
   }
}
