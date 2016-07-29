package careercup.chapter3;

import java.lang.reflect.Array;

public class StackThreeInOne<T extends Comparable<T>> {
	
	int firstTop = -1;
	int secondTop = 0 ;
	int thirdTop = 0;
	int capacity = 0;
    private final T[] array;
	
	@SuppressWarnings("unchecked")
	public StackThreeInOne(Class<T> clazz, int capacity) {
        array = (T[])Array.newInstance(clazz, capacity);
        secondTop = capacity/2;
        thirdTop = capacity;
        this.capacity = capacity;
    }
	
	public void pushFirst(T value){
		if(firstTop==capacity/2){
			System.out.println("First Stack is Full.");
			return;
		}
		array[++firstTop] = value;
	}
	
	public T popFirst(){
		T value = array[firstTop];
		firstTop--;
		return value;
	}
	
	public T peekFirst(){
		return array[firstTop-1];
	}
	
	public void pushSecond(T value){
		if(secondTop==thirdTop){
			System.out.println("Second Stack is Full.");
			return;
		}
		array[secondTop++] = value;
	}
	
	public T popSecond(){
		array[secondTop-1]=null;
		return array[secondTop--];
	}
	
	public T peekSecond(){
		return array[secondTop-1];
	}
	
	public void pushThird(T value){
		if(secondTop==thirdTop){
			System.out.println("Third Stack is Full.");
			return;
		}
		array[--thirdTop] = value;
	}
	
	public T popThird(){
		array[thirdTop]=null;
		return array[thirdTop++];
	}
	
	public T peekThird(){
		return array[thirdTop+1];
	}
	

	public void print(){
	 System.out.println("FirstStack");	
	 for(int i=firstTop;i>=0;i--){
		 System.out.println(array[i]);
		 System.out.println("__");
	 }
	 
	 System.out.println("SecondStack");	
	 for(int i=secondTop-1;i>=capacity/2;i--){
		 System.out.println(array[i]);
		 System.out.println("__");
	 }
	 
	 System.out.println("ThirdStack");	
	 for(int i=thirdTop;i<capacity;i++){
		 System.out.println(array[i]);
		 System.out.println("__");
	 }
	 
	}

	public static void main(String[] args) {
		StackThreeInOne<Integer> stackThreeInOne = new StackThreeInOne<Integer>(Integer.class,10);
		stackThreeInOne.pushFirst(0);
		stackThreeInOne.pushFirst(1);
		stackThreeInOne.pushFirst(2);
		stackThreeInOne.pushFirst(3);
		stackThreeInOne.pushFirst(4);
		stackThreeInOne.popFirst();
		stackThreeInOne.pushFirst(4);
		
		stackThreeInOne.pushSecond(5);
		stackThreeInOne.pushSecond(6);
		stackThreeInOne.pushSecond(7);
		stackThreeInOne.popSecond();
		
		stackThreeInOne.pushThird(9);
		stackThreeInOne.pushThird(8);
		stackThreeInOne.popThird();
		stackThreeInOne.print();
	}

}
