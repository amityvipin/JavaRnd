package sun.java.patterns.observer.inbuild;

import java.util.Observable;

public class ConcreteObservable extends Observable{

	int i = 0;
	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
		this.setChanged();
		this.notifyObservers();
	}

	public static void main(String args[]){
		ConcreteObservable cos = new ConcreteObservable();
		cos.addObserver(new ConcreteObserver());
		cos.setI(3);
		cos.setI(5);
	}
}
