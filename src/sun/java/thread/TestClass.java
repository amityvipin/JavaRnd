package sun.java.thread;

import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		
		Queue<String> queue = new LinkedList<String>();
		Thread producer = new Thread(new Producer(queue));
		Thread consumer = new Thread(new Consumer(queue));
		producer.start();
		consumer.start();

	}

}
