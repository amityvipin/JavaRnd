package careercup.chapter2;

import Common.LinkedListUtils;
import Common.Node;

public class SumOfListSecondLogic {
	static Node<Integer> tail = null;
	public static void main(String args[]) {
		LinkedListUtils<Integer> utils = new LinkedListUtils<Integer>();
		Integer[] values = { 1,3, 5, 8 };
		Integer[] values2 = { 7, 9, 3 };

		Node<Integer> headFirst = utils.createLinkedList(values);
		Node<Integer> headSecond = utils.createLinkedList(values2);
		Node<Integer> resultHead = null;
		resultHead = addListSecondLogic(headFirst, headSecond, resultHead);
		utils.printLinkedList(resultHead);
	}

	private static Node<Integer> addListSecondLogic(Node<Integer> headFirst,
			Node<Integer> headSecond, Node<Integer> resultHead) {
		int carryOver = 0;
		while(headFirst!=null && headSecond!=null){
			Integer temp = headFirst.value + headSecond.value + carryOver;
			carryOver = temp>9?1:0;
			resultHead = addNode(resultHead,new Node<Integer>(temp>9?temp%10:temp, null));
			headFirst = headFirst.next;
			headSecond = headSecond.next;
		}
		carryOver = processLeftOutNodes(headFirst,resultHead,carryOver);
		carryOver = processLeftOutNodes(headSecond,resultHead,carryOver);
		if(carryOver!=0){
			resultHead = addNode(resultHead, new Node<Integer>(carryOver,null));
		}
		return resultHead;
	}

	private static Integer processLeftOutNodes(Node<Integer> head,Node<Integer> resultHead, Integer carryOver){
		while(head!=null){
			Integer temp = head.value + carryOver;
			carryOver = temp>9?1:0;
			resultHead = addNode(resultHead,new Node<Integer>(temp>9?temp%10:temp, null));
			head = head.next;
		}
		return carryOver;
	}
	private static Node<Integer> addNode(Node<Integer> resultHead, Node<Integer> tempNode) {
		if (resultHead == null){
			tail = resultHead = tempNode;
		}
		else {
			tail.next = tail = tempNode;
		}
		return resultHead;
	}
}
