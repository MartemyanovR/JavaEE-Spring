package multithreading.executorCallableFuture;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceTest {
	public static void main(String[] args) throws Exception {
		
        ExecutorService es = Executors.newFixedThreadPool(5);
        List<Callable<Integer>> tasks = new ArrayList<>();
        
        class CubusTask  implements Callable<Integer> {
            int num;
            CubusTask(int num) {
            	this.num = num;
 	        }

            @Override
            public Integer call() throws Exception {
                return num*num*num;
            }
        }

        // Готовим пучок задач
        for(int j=0; j<10; j++) 
        	tasks.add(new CubusTask(j));
        
        // Запускаем их
        List<Future<Integer>> listResult = es.invokeAll(tasks);

        // Ждем завершения
        if (!es.awaitTermination(5, TimeUnit.SECONDS))
            es.shutdownNow();

        // Печатаем подсчитанные результаты
        for(int i=0; i<tasks.size(); i++)
            System.out.println("Cube of " + i + " is " + listResult.get(i).get());

    }

}
