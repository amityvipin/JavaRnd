package careercup.chapter3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class StackOfPlates<T extends Comparable<T>> {
	
	public List<T[]> stacksList = new ArrayList<T[]>();
	public List<Integer> stackTopIndexList = new ArrayList<Integer>();
	int currentStackIndex = 0;
	int top = -1;
	int capacity = 0;
	Class<T> classType = null;
	@SuppressWarnings("unchecked")
	public StackOfPlates(int capacity, Class<T> classType){
		stacksList.add((T[])Array.newInstance(classType, capacity));
		this.capacity = capacity;
		this.classType = classType;
	}
	
	public T pop(){
		if(top==-1 && currentStackIndex==0){
			System.out.println("Stack is Empty.");
			return null;
		}
		if(top==-1 && currentStackIndex>0){
			stacksList.remove(currentStackIndex--);
			top = stackTopIndexList.get(currentStackIndex);
		}
		T value = stacksList.get(currentStackIndex)[top];
		stacksList.get(currentStackIndex)[top--] = null;
		return value;
	}
	
	public void push(T value){
		ensureCapacity();
		stacksList.get(currentStackIndex)[++top] = value;
	}
	
	@SuppressWarnings("unchecked")
	private void ensureCapacity() {
		if(top==capacity-1){
			stackTopIndexList.add(top);
			stacksList.add((T[]) Array.newInstance(classType, capacity));
			currentStackIndex++;
			top = -1;
		}
	}
	
	public T popAt(int index){
		if(index == currentStackIndex)
			return pop();
		T value = stacksList.get(index)[stackTopIndexList.get(index)];
		stacksList.get(index)[stackTopIndexList.get(index)] = null;
		stackTopIndexList.set(index, stackTopIndexList.get(index)-1);
		return value;
	}
	
	public void print(){
		System.out.println("StackOfPlates");
		int topIndex = -1;
		for(int i=stacksList.size()-1;i>=0;i--){
			System.out.println("StackOfPlates index :: "+ i);
			if(i==stacksList.size()-1)
				topIndex = top;
			else
				topIndex = stackTopIndexList.get(i);
			T[] stack = stacksList.get(i);
			for(int j=topIndex;j>=0;j--){
				System.out.println(stack[j]);
				 System.out.println("__");
			}
		}
	}

	public static void main(String[] args) {
		StackOfPlates<Integer> stackOfPlates = new StackOfPlates<>(3,Integer.class);
		stackOfPlates.push(3);
		stackOfPlates.push(4);
		stackOfPlates.push(5);
		stackOfPlates.push(6);
		stackOfPlates.push(7);
		stackOfPlates.push(8);
		stackOfPlates.push(9);
		stackOfPlates.push(10);
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.push(66);
		stackOfPlates.push(76);
		stackOfPlates.popAt(0);
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.pop();
		stackOfPlates.print();
		
	}

}
