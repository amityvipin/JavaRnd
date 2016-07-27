package sun.java.concurrency.executors;

import java.util.concurrent.CountDownLatch;

public class MyThreadforSimpleExec implements Runnable{
	
	String name;
	CountDownLatch cdLatch;
	
	public MyThreadforSimpleExec(String name, CountDownLatch cdLatch){
		this.name = name;
		this.cdLatch = cdLatch;
		new Thread(this);
	}

	@Override
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println(name+" : "+i);
			cdLatch.countDown();
		}
	}
}
