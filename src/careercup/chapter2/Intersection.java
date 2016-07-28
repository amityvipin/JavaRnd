package careercup.chapter2;

public class Intersection {
	
	public static void main(String[] args) {
		Utils<String> utils = new Utils<>();
		Node<String> first = utils.initiailzeLinkedList(new String[]{"n","a","p","i","n"});
		Node<String> second = utils.initiailzeLinkedList(new String[]{"v","i"});
		second.next.next = first.next.next;
		
		isIntersecting(first,second);
	}

	private static void isIntersecting(Node<String> first, Node<String> second) {
		Node<String> first1 = first;
		while(first1.next!=null)
			first1 = first1.next;
		first1.next = second;
		Node<String> intersectingNode = checkCircle(first);
		if(intersectingNode!=null)
			System.out.println("lists are intersecing at node : " + intersectingNode.value);
		else
			System.out.println("lists are not intersecing");
		first1.next = null;
	}

	private static Node<String> checkCircle(Node<String> first) {
		
		Node<String> runner = first;
		Node<String> slow = first;
		boolean isCircle = false;
		while(runner != null && runner.next != null){
			slow = slow.next;
			runner = runner.next.next;
			if(slow == runner){
				isCircle = true;
				break;
			}
		}
		if(isCircle){
			while(first!=slow){
				first = first.next;
				slow = slow.next;
			}
			return slow;
		}
		return null;
	}

}
