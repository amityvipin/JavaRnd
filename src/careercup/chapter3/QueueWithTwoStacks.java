package careercup.chapter3;

import java.util.Stack;

public class QueueWithTwoStacks<E>{
	
	Stack<E> first = new Stack<>();
	Stack<E> second = new Stack<>();
	
	public void add(E value){
		first.add(value);
		
	}

	public E remove(){
		copyStack();
		return second.pop();
	}
	
	public E peek(){
		copyStack();
		return second.peek();
	}
	
	public void print(){
		System.out.println(second.toString() + first.toString());
	}
	
	
	private void copyStack() {
		if(second.isEmpty()){
			while(!first.isEmpty())
				second.push(first.pop());
		}
	}
	

	public static void main(String[] args) {
		QueueWithTwoStacks<String> queue = new QueueWithTwoStacks<>();
		queue.add("Vipin");
		queue.add("Kumar");
		queue.add("Manu");
		queue.add("Batham");
		queue.add("Nikita");
		queue.add("Saroha");
		queue.add("Mohit");
		queue.add("Malik");
		queue.remove();
		queue.print();
	}

}
