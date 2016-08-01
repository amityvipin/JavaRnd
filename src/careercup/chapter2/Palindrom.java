/**
 * 
 */
package careercup.chapter2;

/**
 * @author vipinkumar
 *
 */
public class Palindrom {
	
	public static class Result{
		Node<String> node;
		boolean result;
		
		public Result(Node<String> node, boolean recursive)
		{
			this.node = node;
			this.result = recursive;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Utils<String> utils = new Utils<>();
		Node<String> head = utils.initiailzeLinkedList(new String[]{"n","a","m","a","n"});
		palindromRecursiveApproach(head);
		utils.print(head);
	}
	
	private static void palindromRecursiveApproach(Node<String> head){
		int size =0;
		Node<String> temp = head;
		while(temp!=null){
			size++;
			temp = temp.next;
		}
		Result result = isPalindromRecursive(head,size);
		System.out.println(result.result);
	}
	
	private static Result isPalindromRecursive(Node<String> head, int length){
		if(head==null || length==0)
			return new Result(null,true);
		else if(length==1)
			return new Result(head.next,true);
		else if(length==2)
			return new Result(head.next.next,head.value==head.next.value);
		Result result = isPalindromRecursive(head.next,length-2);
		if(!result.result || result.node==null){
			return result;
		}else{
			result.result = result.node.value == head.value;
			result.node = result.node.next;
			return result;
		}
	}

	private static void checkPalindrom(Node<String> head) {
		if(head==null)
			System.out.println(false);
		else
			System.out.println(check(head));
	}

	private static boolean check(Node<String> head) {
		Node<String> runner = head;
		Node<String> slow = head;
		Node<String> buffer = new Node<String>(head.value,null);
		while(runner!=null && runner.next!=null){
			slow = slow.next;
			if(runner.next.next!=null){
				Node<String> temp = new Node<String> (slow.value,buffer);
				buffer = temp;
			}
			runner = runner.next.next;
		}
		
		while(slow!=null){
			if(!slow.value.equals(buffer.value))
				return false;
			slow = slow.next;
			buffer = buffer.next;
		}
		return true;
	}

}
