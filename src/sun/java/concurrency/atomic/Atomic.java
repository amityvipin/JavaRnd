package sun.java.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

public class Atomic {
	
	public static void main(String args[]){
		new Thread(new MyThread("ThreadA")).start();
		new Thread(new MyThread("ThreadB")).start();
		new Thread(new MyThread("ThreadC")).start();
	}

}

class Shared {
	public static AtomicInteger i = new AtomicInteger(0);
}

class MyThread implements Runnable{
	
	String name;
	
	MyThread(String name){
		this.name = name;
	}
	
	public void run(){
		for(int temp=0;temp<5;temp++)
			System.out.println("Got from " + name+":::"+Shared.i.getAndSet(temp));
	}
}
