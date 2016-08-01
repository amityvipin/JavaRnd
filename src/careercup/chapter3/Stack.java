package careercup.chapter3;

import java.lang.reflect.Array;
import java.util.stream.Stream;

public class Stack<T extends Comparable<T>> {
	
	java.util.Stack<T> stackOfMinimum = new java.util.Stack<T>();
	
	@SuppressWarnings("unchecked")
	public Stack(Class<T> clazz, int capacity) {
        array = (T[])Array.newInstance(clazz, capacity);
    }
	int top = 0;
    private final T[] array;
	public void push(T value){
		if(stackOfMinimum.isEmpty()){
			stackOfMinimum.push(value);
		}else if(stackOfMinimum.peek().compareTo(value)>=0){
			stackOfMinimum.push(value);
		}
		array[top++] = value;
	}
	
	public T pop(){
		if(array[top].compareTo(stackOfMinimum.peek())==0)
			stackOfMinimum.pop();
		array[top]=null;
		return array[top--];
	}
	
	public T peek(){
		return array[top];
	}
	
	public T minimum(){
		return stackOfMinimum.peek();
	}

	public void print(){
	 System.out.println("bottom to top ");	
	 Stream.of(array).forEach(System.out::println);
	}
}
