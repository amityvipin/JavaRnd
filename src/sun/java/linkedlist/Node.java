package sun.java.linkedlist;

public class Node {
	
	public Node next;
	public Node previous;
	public Integer value;
	public Node(Integer value){
		this.value = value;
	}
	
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	public Node getPrevious() {
		return previous;
	}
	public void setPrevious(Node previous) {
		this.previous = previous;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return String.format("|%d,%d|", value, next == null ? 0 : next.value);
	}

}
