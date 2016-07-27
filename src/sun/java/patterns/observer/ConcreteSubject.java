package sun.java.patterns.observer;

import java.util.*;

public class ConcreteSubject implements Subject{
	
	List<Observer> listOfObserver = new ArrayList<Observer>();

	int value = 0;
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
		notifyObserver();
	}

	@Override
	public void registerObserver(Observer obj) {
		listOfObserver.add(obj);
	}

	@Override
	public void removeObserver(Observer obj) {
		listOfObserver.remove(obj);
	}

	@Override
	public void notifyObserver() {
		for(Observer o : listOfObserver){
			o.update(value);
		}
	}
	
	public static void main(String args[]){
		ConcreteSubject obj = new ConcreteSubject();
		obj.registerObserver(new ConcreteObserver());
		obj.registerObserver(new ConcreteObserver2());
		obj.setValue(1);
		obj.setValue(2);
	}

}
