package sun.java.sorting;

import java.util.Arrays;
import java.util.Stack;

public class StackSorting {

	public static void main(String[] args) {
		Integer[] values = {46,26,7,8,3,4,16,2,6,9};
		Stack<Integer> stack = new Stack<Integer>();
		stack.addAll(Arrays.asList(values));
		stack = stackSort(stack);
		for(Integer temp : stack){
			System.out.print(temp + " ");
		}
	}

	private static Stack<Integer>  stackSort(Stack<Integer> stack) {
		
		Stack<Integer> secondryStack = new Stack<Integer>();
		while(!stack.isEmpty()){
			Integer value = stack.pop();
			while(!secondryStack.isEmpty() && secondryStack.peek() > value){
				stack.push(secondryStack.pop());
			}
			secondryStack.push(value);
		}
		return secondryStack;
	}

}
