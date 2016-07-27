package sun.java.concurrency.semaphore;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class BoundedHashSet<T> {
	
	private final Set<T> set;
	private final Semaphore sem;

	public BoundedHashSet(int bound){
		sem = new Semaphore(bound);
		set = Collections.synchronizedSet(new HashSet<T>());
	}
	
	public boolean add(T o) throws InterruptedException{
		sem.acquire();
		boolean wasAdded = false;
		try{
			wasAdded =  set.add(o);
			return wasAdded;
		}finally{
			if(!wasAdded)
				sem.release();
		}
	}
	
	public boolean remove(T o){
		boolean wasRemoved = set.remove(o);
		if(wasRemoved)
			sem.release();
		return wasRemoved;
	}
	public static void main(String[] args) throws InterruptedException {

		BoundedHashSet<String> temp =new BoundedHashSet<String>(1);
		temp.add("one");
		temp.remove("one");
		temp.add("two");
		
		System.out.println(temp);
		
	}

}
