package careercup.chapter2;

public class Utils<T> {

	public Node<T> initiailzeLinkedList(T[] values){
		Node<T> head = null;
		for(int i=values.length-1;i>=0;i--){
			Node<T> temp = new Node<T>(values[i],null);
			if(head==null){
				head = temp;
			}else{
				temp.next = head;
				head = temp;
			}
		}
		return head;
	}
	
	public void print(Node<T> head){
		while(head!=null){
			System.out.print(head.value + " -> ");
			head = head.next;
		}
		System.out.println("null");
	}
}
