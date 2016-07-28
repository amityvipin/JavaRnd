package careercup.chapter2;

import java.util.ArrayList;

import Common.LinkedListUtils;
import Common.Node;

public class RemoveDuplicates {
	
	public static void main(String args[]){
		String[] values = {"vipin", "kumar","manu","batham","kumar","vipin","test"};
		LinkedListUtils<String> utils = new LinkedListUtils<String>();
		Node<String> head = utils.createLinkedList(values);
//		removeDuplicatedRecursive(head, head,new ArrayList<String>());
		removeDuplicatedWithoutBuffer(head);
		utils.printLinkedList(head);
	}
	
	public static void removeDuplicated(Node<String> head){
		if(head==null || head.next==null)
			return;
		ArrayList<String> values = new ArrayList<>();
		Node<String> previousNode = head;
		while(head!=null){
			if(!values.contains(head.value)){
				previousNode = head;
				values.add(head.value);
			}
			else{
				previousNode.next = head.next;
			}
			head = head.next;
		}
	}
	public static void removeDuplicatedRecursive(Node<String> head, Node<String> previousNode, ArrayList<String> values){
		if(head==null || head.next==null)
			return;
		if(!values.contains(head.value)){
			previousNode = head;
			values.add(head.value);
		}
		else{
			previousNode.next = head.next;
		}
		removeDuplicatedRecursive(head.next,previousNode,values);
	}
	public static void removeDuplicatedWithoutBuffer(Node<String> head){
		if(head==null || head.next==null)
			return;
		Node<String> previousNode = head;
		while(head!=null){
			if(!isNodeFound(head,head.next)){
				previousNode = head;
			}
			else{
				previousNode.next = head.next;
			}
			head = head.next;
		}
	}

	private static boolean isNodeFound(Node<String> head, Node<String> searchNode) {
		if(searchNode==null)
			return false;
		while(searchNode!=null){
			if(searchNode.value.equals(head.value))
				return true;
			searchNode = searchNode.next;
		}
		return false;
	}
}
