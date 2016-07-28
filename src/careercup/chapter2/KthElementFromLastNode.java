package careercup.chapter2;

import Common.LinkedListUtils;
import Common.Node;

public class KthElementFromLastNode {
	public static void main(String args[]) {
		String[] values = { "vipin", "kumar", "manu", "batham", "kumar",
				"vipin", "test" };
		LinkedListUtils<String> utils = new LinkedListUtils<String>();
		Node<String> head = utils.createLinkedList(values);
		Node<String> node = printKthElementFromLast(head, 2);
		System.out.println(node.getValue());
		utils.printLinkedList(head);
	}

	private static Node<String> printKthElementFromLast(Node<String> head,
			int index) {

		int size = 0;
		Node<String> heabBackup = head;
		while (head != null) {
			size += 1;
			head = head.next;
		}

		int temp = size - index;

		while (temp > 1) {
			heabBackup = heabBackup.next;
			temp--;
		}
		return heabBackup;

	}

}
