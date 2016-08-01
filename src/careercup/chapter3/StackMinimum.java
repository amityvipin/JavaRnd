package careercup.chapter3;

public class StackMinimum {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(Integer.class,10);
		stack.push(2);
		stack.push(6);
		stack.push(8);
		stack.push(3);
		stack.push(9);
		stack.push(9);
		stack.push(5);
		stack.push(1);
		System.out.println(stack.minimum());
		stack.print();
	}

}
