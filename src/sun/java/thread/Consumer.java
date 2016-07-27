package sun.java.thread;

import java.util.Queue;

public class Consumer implements Runnable{

	private Queue<String> queue = null;
	
	public Consumer(Queue<String> queue){
		this.queue = queue;
	}

	@Override
	public void run() {
		for(int i=0; i<10; i++){
			synchronized(queue){
				System.out.println("consumer value"+queue.poll());
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
