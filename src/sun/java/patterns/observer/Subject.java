package sun.java.patterns.observer;

public interface Subject {
	
	public void registerObserver(Observer obj);
	public void removeObserver(Observer obj);
	public void notifyObserver();

}
