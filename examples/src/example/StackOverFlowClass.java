package example;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class StackOverFlowClass {

	public static void main(String[] args) {
		 ThreadPoolExecutor executor = new ThreadPoolExecutor(1000, 15000, 0L, TimeUnit.MILLISECONDS,
		            new LinkedBlockingQueue<Runnable>());
		    int i = 0;

		    try
		    {

		        Thread.sleep(100);
		        for (; i <= 10; i++)
		        {
		            Runnable t = new Runnable()
		            {
		                List<Object> objects = new LinkedList<>();

		                public void run()
		                {
		                    while (true)
		                    {
		                        objects.add(new Object());
		                    }
		                }
		            };

		            executor.submit(t);

		        }
		    }
		    catch (Throwable e)
		    {
		        System.err.println("stop with " + i + " threads, " + e);
		        System.err.println("task count " + executor.getTaskCount());
		        System.out.println("get active thread count " + executor.getActiveCount());
		        executor.shutdownNow();

		    }
		}

	}


