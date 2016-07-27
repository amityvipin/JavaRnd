package sun.java.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

public class Test {

	public static void main(String args[]){
		
		ReentrantLock lk = new ReentrantLock();
		new LockThread(lk, "ThreadA");
		new LockThread(lk, "ThreadB");
	}
}
