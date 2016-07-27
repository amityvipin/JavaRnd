package sun.java.concurrency.callable;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer>{
	
	int a,b;
	
	Sum(int a, int b){
		this.a = a;
		this.b = b;
	}

	@Override
	public Integer call() throws Exception {
		return a+b;
	}

}
