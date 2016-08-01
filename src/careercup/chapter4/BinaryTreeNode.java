package careercup.chapter4;

public class BinaryTreeNode<T> {
	public T data;
	public BinaryTreeNode<T> left;
	public BinaryTreeNode<T> right;
	public BinaryTreeNode<T> parent;
	
	public BinaryTreeNode(T data){
		this.data = data;
	}
	
	public void inOrder(){
		if(left!=null)
			left.inOrder();
		System.out.println(data);
		if(right!=null)
			right.inOrder();
	}
	
	public void preOrder(){
		System.out.println(data);
		if(left!=null)
			left.preOrder();
		if(right!=null)
			right.preOrder();
	}
	
	public void postOrder(){
		if(left!=null)
			left.postOrder();
		if(right!=null)
			right.postOrder();
		System.out.println(data);
	}
	
}
