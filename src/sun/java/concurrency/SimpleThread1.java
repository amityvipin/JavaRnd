package sun.java.concurrency;

public class SimpleThread1 implements Runnable{

	public void run(){
		for(int i=0;i<5;i++){
			System.out.println(Thread.currentThread().getName()+"::i="+i);
		}
	}
	
	public static void main(String[] args) throws InterruptedException{
		Thread a = new Thread(new SimpleThread1());
		Thread b = new Thread(new SimpleThread1());
		Thread c = new Thread(new SimpleThread1());
		a.start();
		a.join();
		b.start();
		b.join();
		c.start();
	}
}
