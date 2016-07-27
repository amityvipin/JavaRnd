package sun.java.linkedlist;
// two stack in singlearray

// create linkedlist in sorted order

public class SwapToConsecutiveNodes {

	static Node head;

	public static void main(String[] args) {
		intializeList();
		swapNodes();
		printLinkedList();
	}

	private static void swapNodes() {
		if (head == null) {
			return;
		}
		Node start = head;
		boolean flag = true;
		while (head != null && head.next != null) {
			Node temp = head.next.next;
			head.next.next = head;
			if (flag) {
				flag = false;
				start = head.next;
			}
			if(temp!=null && temp.next !=null){
				head.next = temp.next;
			}else{
				head.next = temp;
			}
				head = temp;
		}
		head = start;
	}
	
	private static void printLinkedList() {
		while (head != null) {
			System.out.println(head.getValue());
			head = head.getNext();
		}

	}

	static void intializeList() {
		Integer[] values = new Integer[] { 1, 2, 3,4,5,6,7,8,9,10 ,11,12};
		Node latest = null;
		for (Integer value : values) {
			Node node = new Node(value);
			if (head == null) {
				head = node;
				latest = head;
			} else {
				latest.setNext(node);
				latest = node;
			}
		}
	}

}
