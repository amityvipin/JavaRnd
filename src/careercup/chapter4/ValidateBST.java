package careercup.chapter4;

public class ValidateBST {
	static Integer lastValue = null;
	public static BinaryTreeNode<Integer> createBinaryTree(int[] input){
		BinaryTreeNode<Integer> root = null;
		BinaryTreeNode<Integer> temp = null;
		int size = 0;
		for(int value : input){
			if(root==null){
				root = new BinaryTreeNode<>(value);
				continue;
			}
			if(size%2!=0){
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
	
	public static boolean isBST(BinaryTreeNode<Integer> root){
		if(root!=null){
			if(root.left==null)
				return true;
			if(root.left.data<root.data){
				if(isBST(root.left)){
					if(root.right!=null && root.right.data>root.data)
						return isBST(root.right);
				}else
					return false;
			}else
				return false;
			
			if(root.right==null)
				return true;
			if(root.right.data>root.data){
				if(isBST(root.right)){
					if(root.left!=null && root.left.data<root.data)
						return isBST(root.left);
				}else
					return false;
			}else{
				return false;
			}
		}
		return true;
	}
	
	public static boolean isBST2(BinaryTreeNode<Integer> root){
		if(root==null)
			return true;
		if(!isBST2(root.left))
			return false;
		if(lastValue!=null && root.data <=lastValue)
			return false;
		lastValue = root.data;
		if(!isBST2(root.right))
			return false;
		return true;
	}
	
	public static void main(String args[]){
		MinimalTree minimalTreeNode = new MinimalTree();
//		int[] values = {1,2,7,3,4,5,6};
		Integer[] values = {1,2,3,4,5,6};
//		System.out.println(isBST(createBinaryTree(values)));
		minimalTreeNode.createMinimalTree(values).inOrder();
		System.out.println(isBST(minimalTreeNode.createMinimalTree(values)));
		
		
	}

}
