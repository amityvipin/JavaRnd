package careercup.chapter4;

public class SuccessorNode {
	public static BinaryTreeNode<Integer> successor(BinaryTreeNode<Integer> node){
		if(node.left==null && node.right==null && node.parent.left==node){
			return node.parent;
		}
		if(node.left==null && node.right==null && node.parent.right==node){
			if(node.parent.parent.left==node.parent)
				return node.parent.parent;
			else
				return node.right;
		}
		if(node.parent!=null && ((node.right.data<node.parent.data && node.parent.left==node)|| (node.parent.right==node&&node.right.left==null))) 
			return node.right;
		else{
			node = node.right;
			while(node!=null){
				node = node.left;
				if(node!=null && node.left==null)
					return node;
			}
				
		}
		return null;
	}

	public static void main(String args[]){
		MinimalTree minimalTreeNode = new MinimalTree();
		Integer[] values = {1,2,3,5,6,7,8,9};
		BinaryTreeNode<Integer> root = minimalTreeNode.createMinimalTree(values);
		System.out.println(successor(root.right.left));
	}
}
