package multithreading.executorCallableFuture;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableTest {
	
	
	public CallableTest() {
		// Определяем пул из трех потоков
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		 // Список ассоциированных с Callable задач Future 
		List<Future<String>> futureString = new ArrayList<>();
		
		// Создание экземпляра Callable класса
		Callable<String> callable = new CallableClass();
		
		for(int i = 0 ; i<3; i++) {
			 /*
             * Стартуем, возвращаюший результат исполнения 
             * в виде объекта Future, поток
             */
			Future<String> future = executor.submit(callable);
			/*
             * Добавляем объект Future в список для 
             * отображения результат выполнения (получение
             * наименования потока)
             */
			futureString.add(future);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		//Класс CallableClass, реализующий интерфейс Callable, использует объект String в качестве generic'a.
		//Соответственно и каждый объект Future также должен использовать тип объекта String.
		for(Future<String> future: futureString) {
			try {
				// Выводим в консоль полученное значение
				String text = sdf.format(new Date()) + " " + future.get();
				System.out.println(text);
			}catch(InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}	

}
