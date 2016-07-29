package careercup.chapter3;

import java.lang.reflect.Array;
import java.util.stream.Stream;

public class Stack<T extends Comparable<T>> {
	
	@SuppressWarnings("unchecked")
	public Stack(Class<T> clazz, int capacity) {
        array = (T[])Array.newInstance(clazz, capacity);
    }
	int top = 0;
    private final T[] array;
	int mininumIndex = -1;
	public void push(T value){
		if(mininumIndex==-1 || value.compareTo(array[mininumIndex])<0){
			mininumIndex = top;
		}
		array[top++] = value;
	}
	
	public T pop(){
		array[top]=null;
		return array[top--];
	}
	
	public T peek(){
		return array[top];
	}
	
	public T minimum(){
		return array[mininumIndex];
	}

	public void print(){
	 System.out.println("bottom to top ");	
	 Stream.of(array).forEach(System.out::println);
	}
}
