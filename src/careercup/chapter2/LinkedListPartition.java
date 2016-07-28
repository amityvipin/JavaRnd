package careercup.chapter2;

import Common.LinkedListUtils;
import Common.Node;

public class LinkedListPartition {
	public static void main(String args[]){
		Integer[] values = {3,5,8,5,10,2,1};
		LinkedListUtils<Integer> utils = new LinkedListUtils<Integer>();
		Node<Integer> head = utils.createLinkedList(values);
		partition(head,5);
		utils.printLinkedList(head);
	}

	
	private static void partition2(Node<Integer> head, int partitionValue){
		if(head==null||head.next==null)
			return;
		// find partition nodes
		Node<Integer> headBackup = head;
		Node<Integer> partitionNode = null;
		Node<Integer> partitionPreviousNode = null;
		while(head!=null){
			
			if(partitionNode==null && head.value == partitionValue){
				partitionNode = head;
				head = head.next;
			}
			else if(partitionNode!=null && head.value == partitionValue){
				Node<Integer> headNext = head.next;
				Node<Integer> partitionNodeNext = partitionNode.next;
				partitionNode.next = head;
				head.next = partitionNodeNext;
				partitionNodeNext.next = headNext;
				head = headNext;
			}else{
				if(partitionNode==null)
					partitionPreviousNode = head;
				head = head.next;
			}
		}
		
		head = headBackup;
		partitionNode = partitionNode.next;
		Node<Integer> previousNode = null;
		while(partitionNode!=null){
			if(partitionNode.value == partitionValue){
				previousNode = partitionNode;
				partitionNode = partitionNode.next;
				continue;
			}
			Node<Integer> temp = partitionPreviousNode.next;
			partitionPreviousNode.next = partitionNode;
			Node<Integer> temp2 = partitionNode.next;
			previousNode.next = temp2;
			partitionNode.next = temp;
			partitionNode = temp2;
		}
	}
	
	private static void partition(Node<Integer> head, int partitionValue) {
		if(head==null||head.next==null)
			return;
		Node<Integer> partitionNode = null;
		Node<Integer> partitionPreviousNode = null;
		Node<Integer> previousNode = null;
		while(head!=null){
			if(partitionNode==null && head.value<partitionValue){
				partitionPreviousNode = head;
				previousNode = head;
				head = head.next;
			}
			else if(partitionNode==null && head.value==partitionValue){
				partitionNode = head;
				previousNode = head;
				head = head.next;
			}
			else if(partitionNode!=null && head.value==partitionValue){
				Node<Integer> temp = partitionNode.next;
				partitionNode.next = head;
				Node<Integer> temp2 = head.next;
				head.next = temp;
				temp.next = temp2;
				previousNode = head;
				head = temp2;
			}else if(partitionNode!=null && head.value>partitionValue){
				previousNode = head;
				head = head.next;
			}
			else{
				partitionPreviousNode.next = head;
				Node<Integer> temp2 = head.next;
				head.next = partitionNode;
				partitionPreviousNode = head;
				head = temp2;
				previousNode.next=temp2;
			}
		}
	}
}
