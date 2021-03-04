package multithreading.executorCallableFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * пример использования FutureTask, в котором создается пул из 3-х потоков, 
 * реализующих интерфейс Callable в виде класса CallableDelay. 
 * Основная идея примера связана с проверками выполняемых потоков и 
 * отмены выполнения задачи одного из потоков.
 */
public class FutureTaskExmple {
	CallableDelay[] callable = null;
	FutureTask<String>[] futureTask =  null;
	ExecutorService executor = null;
	private final int THREAD_COUNT = 3;

//--------------------------------------------------------------------------------------------------------------------------	
	class CallableDelay implements Callable<String> {
     	 private  long  delay;
     	 private  int   idx  ;
     	 private  int   cycle;


		//Конструктор класса CallableDelay в качестве параметров получает временно́й размер задержки delay
		//и идентификатор потока. 
		public CallableDelay(long delay, int idx) {
			this.delay = delay;
			this.idx = idx;
			this.cycle = idx;
		}

		//В зависимости от значения идентификатора потока в методе call() 
		//выполняется соответствующее количество циклов с заданной задержкой, после чего поток завершает работу.
		@Override
		public String call() throws Exception {
			//В зависимости от значения идентификатора потока в методе call() 
			//выполняется соответствующее количество циклов с заданной задержкой, после чего поток завершает работу.
			while(cycle > 0) {
				System.out.println("Cycle: " + cycle + " " + Thread.currentThread().getName());
				TimeUnit.SECONDS.sleep(delay);
				
				cycle--;
				//Второй поток на первом цикле прерывает выполнение 3-го потока вызовом метода cancel. 
				if((idx == 2) && (cycle > 0)) {
					System.out.println("прерывание 3го потока...");
					futureTask[futureTask.length-1] .cancel(true);	
					
				}
			}
			return " " + idx + ". " + Thread.currentThread().getName();
		}		
	}
//--------------------------------------------------------------------------------------------------------------------------	
	/*
	 * 	Метод areTasksDone() проверяет завершение выполнения всех задач/потоков вызовом методов isDone()
	 *  объектов futureTask. Если выполнение всех потоков завершены, то сервис executor
	 *   останавливает свою работу методом shutdown().
	 */
	private boolean areTasksDone() {
		boolean isDone= true;
		for(int i = 0 ; i< THREAD_COUNT; i++) {
			if(!futureTask[i].isDone()) {
				isDone = false;
				break;
			}
		}
		return isDone;
	}
	
//--------------------------------------------------------------------------------------------------------------------------
		//В конструкторе примера создаются два массива из объектов типа CallableDelay и FutureTask.		
		@SuppressWarnings("unchecked")
		public FutureTaskExmple ()  {
			callable = new CallableDelay[THREAD_COUNT];
			futureTask = new FutureTask[THREAD_COUNT];
			int tempFirst = 0;
			
			// Сервис исполнения
			executor = Executors.newFixedThreadPool(THREAD_COUNT);
			
			//После этого формируется пул для трех потоков сервиса типа ExecutorService и потоки стартуют
			//методом execute сервиса executor.
			for(int i = 0 ; i< THREAD_COUNT; i++ ) {
				callable[i] = new CallableDelay(5, (i+1));
				futureTask[i] = new FutureTask<String>(callable[i]);
				executor.execute(futureTask[i]);
			}
			// Цикл работы executor'а
			// В цикле выполняются различного рода проверки : 
			//завершения работы потока методом isDone(), ожидания завершения потока методом get() 
			//с временны́ми параметрами и отмены выполнения потока методом isCancelled().
			while(true) {				
				try {
					if(areTasksDone()) {
						// Завершение работы executor'а
						executor.shutdown();
						System.out.println("\nexecutor shutdown");
						return;
					}
					//TimeUnit.SECONDS.sleep(1);
					// Проверка завершения выполнения задачи 1-м 
	                // потоком
					if(tempFirst == 0 && futureTask[0].isDone()) {
						System.out.println("первый поток завершен" + futureTask[0].get());
						tempFirst++;
					}
					System.out.println("Ожидание завершения 2-го потока");
					String txt = futureTask[1].get(1000l,TimeUnit.MILLISECONDS);
					if(txt !=  null)
						System.out.println("2-ой поток завершен : " + txt);
					System.out.println("Проверка завершения 3-го потока");
					if(futureTask[2].isCancelled())
						System.out.println("3-ой поток был прерван ...");
					else if(futureTask[2].isDone()) {
						txt = futureTask[2].get();
						 System.out.println("3-ий поток завершен : "+txt);				
					}
					Thread.sleep(200);					
				} catch(InterruptedException | ExecutionException e) {
					System.err.println(e.getMessage());
				}
				catch(TimeoutException e) {
					 System.err.println("TimeoutException");
				}
			}
		}
			
		public static void main(String[] args) {
			new FutureTaskExmple();
		}	
}
/*
 * Результат работы примера.
 * При выполнении задачи информационные сообщения, представленные ниже, выводятся в консоль.
 * Согласно последовательности вывода сообщений можно сказать, что при вызове метода isDone()
 * объекта FutureTask 1-го потока программа перешла в режим ожидания завершения работы потока.
 * После завершения выполнения 1-го потока программа перешла к проверке 2-го потока методом get()
 * с временно́й задержкой.Так как за предоставленное время поток не смог завершить работу,
 * то был вызван TimeoutException и цикл проверки повторился снова.
 * Только после завершения работы 2-го потока программа перешла к проверке отмены/завершения 
 * 3-го потока. Метод isCancelled() подтвердил, что выполнение потока было прервано.
 *  Только после этого метод areTasksDone() подтвердил, что все потоки завершили выполнение
 *   и цикл проверок был прерван, сервис executor завершил выполнение методом shutdown().
 */












