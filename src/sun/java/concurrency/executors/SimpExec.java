package sun.java.concurrency.executors;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpExec {
	
	public static void main(String args[]){
		
		CountDownLatch cd1 = new CountDownLatch(5);
		CountDownLatch cd2 = new CountDownLatch(5);
		CountDownLatch cd3 = new CountDownLatch(5);
		CountDownLatch cd4 = new CountDownLatch(5);
		
		/// executer service now have only 2 threads concurrently only two threads can be executed.
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		
		executorService.execute(new MyThreadforSimpleExec("Thread1", cd1));
		executorService.execute(new MyThreadforSimpleExec("Thread2", cd2));
		executorService.execute(new MyThreadforSimpleExec("Thread3", cd3));
		executorService.execute(new MyThreadforSimpleExec("Thread4", cd4));
		
		try {
			// CountdownLatch will wait till all the event occurred (i.e. for this example 5 events which was defined during latch construction)
			cd1.await();
			cd2.await();
			cd3.await();
			cd4.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		//if you comment out below method then program will not terminate
		// After this method call it will not imediate shutdown the executer, First it will finish all tasks(but will not accept new tasks) then it will terminate
		//using shutdownNow() method you can shutdown executer service immediately
		executorService.shutdown();
		
	}

}
