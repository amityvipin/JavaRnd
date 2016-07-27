package sun.java.patterns.observer;

public class ConcreteObserver2 implements Observer {

	@Override
	public void update(int value) {
		System.out.println(Thread.currentThread().getName() + "::" + value);
		
	}

}
