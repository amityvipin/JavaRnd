package careercup.chapter4;

public class MinimalTree {

	public BinaryTreeNode<Integer> createMinimalTree(int[] input){
		BinaryTreeNode<Integer> root = null;
		BinaryTreeNode<Integer> temp = null;
		int size = 0;
		for(int value : input){
			if(root==null){
				root = new BinaryTreeNode<>(value);
				continue;
			}
			if(size%2==0){
				temp = new BinaryTreeNode<>(value);
				root.parent = temp;
				temp.left = root;
				root = temp;
			}else{
				temp = new BinaryTreeNode<>(value);
				temp.parent = root;
				root.right = temp;
			}
			size++;
		}
		return root;
	}
	
	public static void main(String args[]){
		MinimalTree minimalTreeNode = new MinimalTree();
		int[] values = {1,2,3,4,5,6,7,8,9};
		minimalTreeNode.createMinimalTree(values).preOrder();
	}
}
