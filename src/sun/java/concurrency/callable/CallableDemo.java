package sun.java.concurrency.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
	
	public static void main(String args[]){
		ExecutorService es = Executors.newFixedThreadPool(2);
		Future<Integer> value1 = es.submit(new Sum(5, 6));
		Future<Integer> value2 = es.submit(new Sum(8,9));
		Future<Integer> value3 = es.submit(new Minus(8,9));
		Future<Integer> value4 = es.submit(new Minus(99,9));
		
		try {
			System.out.println(value2.get());
			System.out.println(value1.get());
			
			System.out.println(value3.get());
			System.out.println(value4.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		es.shutdown();
	}

}
