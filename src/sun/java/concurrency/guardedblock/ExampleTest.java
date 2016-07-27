package sun.java.concurrency.guardedblock;

public class ExampleTest {

	public static void main(String args[]){
		Drop drop = new Drop();
		new Thread(new Producer(drop)).start();
		new Thread(new Consumer(drop)).start();
	}
}
