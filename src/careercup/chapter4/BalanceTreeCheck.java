package careercup.chapter4;

public class BalanceTreeCheck {

	public static boolean isBalancedTree(BinaryTreeNode<Integer> root){
		int heightLeft = getTreeHeight(root.left);
		int heightRight = getTreeHeight(root.right);
		if(heightLeft-heightRight==1 || heightLeft-heightRight==-1 || heightLeft-heightRight==0)
			return true;
		return false;
	}

	private static int getTreeHeight(BinaryTreeNode<Integer> node) {
		if(node==null)
			return 0;
		else{
			int leftHeight = getTreeHeight(node.left)+1;
			int rightHeight = getTreeHeight(node.right)+1;
			return leftHeight>rightHeight?leftHeight:rightHeight;
		}
	}
	
	public static void main(String args[]){
		MinimalTree test = new MinimalTree();
		Integer[] value = {1,2,3,4,5,6,7,8,9};
		BinaryTreeNode<Integer> root = test.createMinimalTree(value);
//		int[] value = {1,2,3,4,5,6,7,8,9};
//		BinaryTreeNode<Integer> root = test.createTree(value);
		System.out.println(isBalancedTree(root));
	}
}
