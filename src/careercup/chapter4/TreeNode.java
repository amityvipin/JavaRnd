package careercup.chapter4;

public class TreeNode<T> {
	T data;
	TreeNode<T> parent;
	TreeNode<T> leftMostChild;
	TreeNode<T> rightSibling;
	
	public TreeNode(T data, TreeNode<T> parent){
		this.data = data;
		this.parent = parent;
	}
	
}
