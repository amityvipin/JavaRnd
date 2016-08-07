package careercup.chapter4;

import java.util.LinkedList;
import java.util.List;

public class FirstCommonAncestorTwo {
	
	public static void postOrder(BinaryTreeNode<Integer> node,LinkedList<BinaryTreeNode<Integer>> postList){
		if(node!=null)
			postOrder(node.left,postList);
		if(node!=null)
			postOrder(node.right,postList);
		postList.add(node);
	}
	public static void inOrder(BinaryTreeNode<Integer> node,LinkedList<BinaryTreeNode<Integer>> inList){
		if(node!=null)
			inOrder(node.left,inList);
		inList.add(node);
		if(node!=null)
			inOrder(node.right,inList);
		
	}
	
	public static BinaryTreeNode<Integer> commonAncestor(BinaryTreeNode<Integer> root,BinaryTreeNode<Integer> p,BinaryTreeNode<Integer> q){
		LinkedList<BinaryTreeNode<Integer>> inList = new LinkedList<>();
		LinkedList<BinaryTreeNode<Integer>> postList = new LinkedList<>();
		postOrder(root,postList);
		inOrder(root,inList);
		List<BinaryTreeNode<Integer>> inSubList = inList.subList(inList.indexOf(p),inList.indexOf(q));
		int index=-1;
		for (BinaryTreeNode<Integer> binaryTreeNode : inSubList) {
			int postIndex = postList.indexOf(binaryTreeNode);
			if(postIndex>index)
				index = postIndex;
		}
		return postList.get(index);
	}
	public static void main(String args[]){
		MinimalTree minimalTreeNode = new MinimalTree();
		Integer[] values = {1,2,3,5,6,7,8,9};
		BinaryTreeNode<Integer> root = minimalTreeNode.createMinimalTree(values);
//		root.postOrder();
		System.out.println(commonAncestor(root,root.right.left,root.right.right));
	}

}
