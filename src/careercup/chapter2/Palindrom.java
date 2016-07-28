/**
 * 
 */
package careercup.chapter2;

/**
 * @author vipinkumar
 *
 */
public class Palindrom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Utils<String> utils = new Utils<>();
		Node<String> head = utils.initiailzeLinkedList(new String[]{"n","a","m","n"});
		checkPalindrom(head);
		utils.print(head);
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
