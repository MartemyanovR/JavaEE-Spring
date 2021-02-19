package multithreading.ekkel.ex_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {

	public static void main(String[] args) {
		
		/*
		 * создает столько потоков, сколько требуется во время выполнения программы, 
		 * после чего перестает создавать новые потоки и повторно использует уже существующие
		 */
		ExecutorService exec = Executors.newCachedThreadPool();
		
		/*
		 * здесь мы контролируем сколько потоков будет выполнять эту задачу
		 * Перерасход ресурсов исключен, потому что FixedThreadPool использует ограниченное количество объектов Thread.
		 */
		ExecutorService exec1 = Executors.newFixedThreadPool(5); //ограниченный набор потоков для выполнения переданных задач
		
		/*
		 * использует всего один поток
		 * Если объект SingleThreadExecutor получает более одной задачи, то эти задачи ставятся в очередь.
		 *  Каждая задача выполняется до завершения, после чего запускается следующая задача;
		 *   при этом все они используют один поток
		 */
		ExecutorService single = Executors.newSingleThreadExecutor();
		
		for(int i = 0; i < 5; i++) {
			exec1.execute(new Ex_1()); /* rather(вместо того) than invoking new Thread(new(RunnableTask())).start() for each of a set of task*/
		}
			exec1.shutdown();		
	}
}
