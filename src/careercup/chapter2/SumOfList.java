package careercup.chapter2;

import Common.LinkedListUtils;
import Common.Node;

public class SumOfList {
	public static void main(String args[]) {
		LinkedListUtils<Integer> utils = new LinkedListUtils<Integer>();
		Integer[] values = { 3, 5, 8 };
		Integer[] values2 = { 7, 9, 3 };

		Node<Integer> headFirst = utils.createLinkedList(values);
		Node<Integer> headSecond = utils.createLinkedList(values2);
		Node<Integer> resultHead = new Node<Integer>(0, null);
		resultHead = addListFirstLogic(headFirst, headSecond, resultHead);
		utils.printLinkedList(resultHead);
	}

	private static Node<Integer> addListFirstLogic(Node<Integer> headFirst,
			Node<Integer> headSecond, Node<Integer> resultHead) {
		Node<Integer> headSecond2 = headSecond;
		Node<Integer> headFirst2 = headFirst;
		while(headFirst!=null && headSecond!=null){
			headFirst = headFirst.next;
			headSecond = headSecond.next;
		}
		while(headFirst!=null){
			Node<Integer> temp = new Node<>(0,headSecond2);
			headSecond2 = temp;
			headFirst = headFirst.next;
		}
		while(headSecond!=null){
			Node<Integer> temp = new Node<>(0,headFirst2);
			headFirst2 = temp;
			headSecond = headSecond.next;
		}
		Integer value = addList(headFirst2, headSecond2, resultHead, 0);
		if(value==0){
			resultHead = resultHead.next;
		}else{
			resultHead.value=value;
		}
		return resultHead;
	}

	private static Integer addList(Node<Integer> headFirst,
			Node<Integer> headSecond, Node<Integer> resultHead,
			Integer carryOverValue) {

		if (headFirst.next != null && headSecond.next != null) {
			carryOverValue = addList(headFirst.next, headSecond.next, resultHead,
					carryOverValue);
		}
		Integer temp = headFirst.value + headSecond.value + carryOverValue;
		carryOverValue = temp>9?Integer.parseInt(String.valueOf(temp).charAt(0) + ""):0;
		Node<Integer> tempNode = new Node<Integer>(temp>9?Integer.parseInt(String
				.valueOf(temp).charAt(1) + ""):temp, null);
		addNode(resultHead, tempNode);
		return carryOverValue;
	}

	private static void addNode(Node<Integer> resultHead, Node<Integer> tempNode) {
		if (resultHead.next == null)
			resultHead.next = tempNode;
		else {
			Node<Integer> tempNode2 = resultHead.next;
			resultHead.next = tempNode;
			tempNode.next = tempNode2;
		}
	}
}
