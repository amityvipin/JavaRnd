package sun.java.linkedlist;

/**
 * Here the concept follows that fast always traverse 2 multiple path then slow
 * pointer. So when they meet if we start slow from the starting and then start
 * fast from the meeting point(i.e. where they meet while identifying the
 * circle) at same speed then they will meet at the start point of the circle
 * 
 * http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 * 
 * 
 * 
 * 
 * @author Vipin
 *
 */
public class CircleStartPoint {

	static Node head;
	
	static Integer[] values = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };

	public static void main(String[] args) {

		intializeList();
		printLinkedList();
		findCircle();

	}

	private static void findCircle() {
		Node slow = head;
		Node fast = head;
		boolean start = true;
		boolean ifCircleExists =false;
		while (slow != fast || start) {
			start = false;
			try{
				slow = slow.getNext();
				fast = fast.getNext().getNext();
			}catch(Exception e){
				//skip
			}
		}
		
		ifCircleExists = slow == fast ? true : false;
		
		if(ifCircleExists){
			System.out.println("\nYes this list contains circle.");
			slow = head;
			while (slow != fast) {
				slow = slow.getNext();
				fast = fast.getNext();
			}
			System.out.println("\n" + slow.getValue());
		}else{
			System.out.println("\nCircle do not exists.");
		}
	}

	private static void printLinkedList() {
		for(int i = 0; i < values.length; i++){
			System.out.print(head + " -> ");
			head = head.getNext();
		}
		/*while (head != null) {
			System.out.print("|" + head.getValue() + "|->");
			head = head.getNext();
		}*/

	}

	static void intializeList() {
		Node latest = null;
		Node middlePoint = null;
		for (Integer value : values) {
			Node node = new Node(value);
			if (value == 9) {
				middlePoint = node;
			}
			if (head == null) {
				head = node;
				latest = head;
			} else {
				latest.setNext(node);
				latest = node;
			}
			if (value == 11) {
				//node.setNext(middlePoint);
			}
		}
	}

}
