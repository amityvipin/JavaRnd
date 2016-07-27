package sun.java.thread;

import java.util.Queue;

public class Producer implements Runnable{

	private Queue<String> queue = null;
	
	public Producer(Queue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			synchronized(queue){
				
				System.out.println("provider Value "+ i);
				queue.add("provider Value "+ i);
				queue.notify();
				try {
					queue.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
	}
}
