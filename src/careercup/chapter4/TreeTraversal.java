package careercup.chapter4;

public class TreeTraversal {
	
	
	public static void main(String args[]){
		TreeNode<String> root = new TreeNode<>("root",null);
		root.leftMostChild = new TreeNode<>("left1",root);
		root.leftMostChild.rightSibling = new TreeNode<>("left2",root);
		root.leftMostChild.rightSibling.rightSibling = new TreeNode<>("left3",root);
		root.leftMostChild.leftMostChild = new TreeNode<>("left11",root.rightSibling);
		
		preOrderTraversal(root);
	}

	private static void preOrderTraversal(TreeNode<String> root) {
		System.out.print(root.data + "->");
		if(root.leftMostChild!=null){
			preOrderTraversal(root.leftMostChild);
			if(root.leftMostChild.rightSibling!=null)
				preOrderTraversal(root.leftMostChild.rightSibling);
		}
	}

}
