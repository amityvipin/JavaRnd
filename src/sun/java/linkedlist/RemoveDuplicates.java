package sun.java.linkedlist;

import java.util.HashSet;

public class RemoveDuplicates {
	static Node head;
	
	public static void main(String[] args) {
		intializeList();
		removeDuplicates();
		printLinkedList();
	}
	private static void removeDuplicates() {
		// we will use hashing mechanism to 
		HashSet<Integer> valueMap = new HashSet<>();
		Node temp = head;
		Node previous = null;
		while(temp!=null){
			if(valueMap.contains(temp.getValue())){
				Node next = temp.getNext();
				previous.setNext(next);
			}else{
				valueMap.add(temp.getValue());
				previous = temp;
			}
			temp = temp.getNext();
		}
	}
	private static void printLinkedList() {
		while(head!=null){
			System.out.println(head.getValue());
			head = head.getNext();
		}
		
	}
	static void intializeList() {
		Integer[] values = new Integer[]{1,2,3,4,5,6,6,7,7,8,9,9,10,11};
		Node latest = null;
		for(Integer value : values){
			Node node = new Node(value);
			if(head==null){
				head = node;
				latest = head;
			}
			else{
				latest.setNext(node);
				latest = node;
			}
		}
	}

}
