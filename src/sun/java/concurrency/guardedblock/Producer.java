package sun.java.concurrency.guardedblock;

import java.util.Random;

public class Producer implements Runnable {
	private Drop drop ; 
	
	Producer(Drop drop){
		this.drop = drop;
	}
	public void run() {
		String[] messages = {"first message","second message", "third message", "fourth message"};
		Random random = new Random();
		for(String message: messages){
			drop.put(message);
			try {
				Thread.sleep(random.nextInt(5000));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		drop.put("DONE");
	}
}
