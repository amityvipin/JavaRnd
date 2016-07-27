package sun.java.concurrency.callable;

import java.util.concurrent.Callable;

public class Minus implements Callable<Integer>{

	int a,b;
	
	Minus(int a, int b){
		this.a = a;
		this.b = b;
	}
	
	public Integer call(){
		return a - b;
	}
}
