package careercup.chapter2;

import Common.LinkedListUtils;
import Common.Node;

public class RemoteMiddleNode {

	public static void main(String args[]){
		String[] values = {"vipin","kumar","test","test2"};
		LinkedListUtils<String> utils = new LinkedListUtils<String>();
		Node<String> head = utils.createLinkedList(values);
		remoteMiddleNode(head);
		utils.printLinkedList(head);
	}

	private static void remoteMiddleNode(Node<String> head) {
		
		if(head==null || head.next==null)
			return;
		int size = 0;
		Node<String> heabBackup = head;
		while(head!=null){
			size+=1;
			head = head.next;
		}
		
		int index = size/2;
		index = (size%2==0)?index-1:index;
		
		while(index>1){
			heabBackup = heabBackup.next;
			index--;
		}
		if(size==2){
			heabBackup.value = heabBackup.next.value;
			heabBackup.next = heabBackup.next.next;
		}else{			
			heabBackup.next = heabBackup.next.next;
		}
		
	}
	
}
