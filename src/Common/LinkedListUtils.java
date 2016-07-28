package Common;


public class LinkedListUtils<T> {
	public Node<T> createLinkedList(T[] values){
		Node<T> head = null;
		Node<T> tail = null;
		for(int i=0;i<values.length;i++){
			if(i==0){
				head = new Node<T>(values[i],null);
				tail = head;
			}else{
				Node<T> temp = new Node<T>(values[i],null);
				tail.next = temp;
				tail = temp;
			}
		}
		return head;
	}
	
	public void printLinkedList(Node<T> node){
		if(node==null)
			return;
		if(node.next==null){
			System.out.println(node.value);
			return;
		}
		while(node!=null){
			System.out.print(node.value + " -> " );
			node = node.next;
		}
		System.out.println("null");
	}

}
