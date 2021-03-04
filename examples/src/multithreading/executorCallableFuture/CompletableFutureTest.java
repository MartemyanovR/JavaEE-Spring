package multithreading.executorCallableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public class CompletableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
	/*	CompletableFuture<Void> compFuture  = CompletableFuture.runAsync(()-> {
			try {
				TimeUnit.SECONDS.sleep(1);
				
			} catch(InterruptedException e) {
				throw new IllegalStateException();
			}		
			System.out.println("Я буду работать в отдельном потоке, а не в главном.");
		});		
		compFuture.get();*/
		
//-------------------------------------------------------------------------------------------------------		
	
		// Запуск асинхронной задачи, заданной объектом Supplier(вызов метода get)
/*		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
		        try {
		            TimeUnit.SECONDS.sleep(1);
		        } catch (InterruptedException e) {
		            throw new IllegalStateException(e);
		        }
		        return "Результат асинхронной задачи";
    	});
		 
		// Блокировка и получение результата Future
		String result = future.get();
		System.out.println(result);		*/
		
		/*
		 * Вы можете поинтересоваться: хорошо, runAsync() и supplyAsync() выполняются в отдельном потоке,
		 * но мы ведь нигде не создавали новый поток, верно?
         * Верно! CompletableFuture выполняет эти задачи в потоке,
         *  полученном из глобального ForkJoinPool.commonPool().
		 */
		/*
		 * Также вы можете создать пул потоков и передать его методам runAsync() и supplyAsync(),
		 *  чтобы они выполняли свои задачи в потоке, полученном уже из вашего пула потоков.
		 */
		
//----------------------------------------------------------------------------------------------------------
		//thenApply()
		// Создаём CompletableFuture
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
		   try {
		       TimeUnit.SECONDS.sleep(1);
		   } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		   }
		   return "Rajeev";
		});
		 
		// Добавляем колбэк к Future, используя thenApply()
		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
		    return "Привет," + name;
		});
		 
		// Блокировка и получение результата Future
		System.out.println(greetingFuture.get()); // Привет, Rajeev
		
//----------------------------------------------------------------------------------------------------
		CompletableFuture<String> welcomeText = CompletableFuture.supplyAsync(() -> {
		    try {
		        TimeUnit.SECONDS.sleep(1);
		    } catch (InterruptedException e) {
		       throw new IllegalStateException(e);
		    }
		    return "Rajeev";
		}).thenApply(name -> {
		    return "Привет," + name;
		}).thenApply(greeting -> {
		    return greeting + ". Добро пожаловать в блог CalliCoder";
		});
		 
		System.out.println(welcomeText.get());
		// Выводит: Привет, Rajeev. Добро пожаловать в блог CalliCoder
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
