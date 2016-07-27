package sun.java.concurrency.lock;

import java.util.concurrent.locks.Lock;

public class LockThread implements Runnable{
	
	Lock lk;
	String name;
	
	LockThread(Lock lk, String name){
		this.lk = lk;
		this.name = name;
		new Thread(this).start();
	}
	public void run(){
		System.out.println(name +"is waiting for lock");
		lk.lock();
		System.out.println("lock is aquired");
		Shared.count ++ ;
		System.out.println("value is "+Shared.count +" via "+ name);
		lk.unlock();
	}

}

class Shared{
	static int count = 0;
}