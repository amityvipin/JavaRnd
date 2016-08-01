package careercup.chapter3;

public class SortStack {
	
	public void sortStack(java.util.Stack<String> stack){
		java.util.Stack<String> stack2 = new java.util.Stack<String>();
		while(!stack.isEmpty()){
			insertValueInStack2(stack,stack2, stack.pop());
		}
		
		while(!stack2.isEmpty()){
			stack.push(stack2.pop());
		}
		System.out.println(stack);
	}

	private void insertValueInStack2(java.util.Stack<String> stack, java.util.Stack<String> stack2, String value) {
		if(stack2.isEmpty() || stack2.peek().compareTo(value)>=0)
			stack2.push(value);
		else{
			int count = 0;
			while(!stack2.isEmpty() && stack2.peek().compareTo(value)<0){
				stack.push(stack2.pop());
				count++;
			}
			stack2.push(value);
			while(count>0){
				stack2.push(stack.pop());
				count--;
			}
		}
	}

	public static void main(String[] args) {
		
		SortStack sortStack = new SortStack();
		java.util.Stack<String> stack = new java.util.Stack<String>();
		stack.add("Vipin");
		stack.add("Kumar");
		stack.add("Manu");
		stack.add("Batham");
		stack.add("Nikita");
		stack.add("Saroha");
		stack.add("Mohit");
		stack.add("Malik");
		sortStack.sortStack(stack);
	}

}
