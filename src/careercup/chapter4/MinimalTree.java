package careercup.chapter4;

import java.util.Arrays;
import java.util.List;

public class MinimalTree {

	public BinaryTreeNode<Integer> createTree(int[] input){
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
	
	public BinaryTreeNode<Integer> createMinimalTree(Integer[] input){
		List<Integer> inputList = Arrays.asList(input);
		return balance(inputList);
	}
	
	private BinaryTreeNode<Integer> balance(List<Integer> inputList) {
		if(inputList.isEmpty())
			return null;
		int midIndex = inputList.size()%2==0?inputList.size()/2-1:inputList.size()/2;
		int value = inputList.get(midIndex);
		BinaryTreeNode<Integer> node = new BinaryTreeNode<>(value);
		node.left = balance(inputList.subList(0, midIndex));
		if(node.left!=null)
			node.left.parent=node;
		node.right = balance(inputList.subList(midIndex+1, inputList.size()));
		if(node.right!=null)
			node.right.parent=node;
		return node;
	}


	public static void main(String args[]){
		MinimalTree minimalTreeNode = new MinimalTree();
		Integer[] values = {1,2,3,4,5,6};
		minimalTreeNode.createMinimalTree(values).preOrder();
	}
}
