package careercup.chapter4;

import java.util.ArrayList;
import java.util.LinkedList;

public class ListOfDepths {
	
	public ArrayList<LinkedList<BinaryTreeNode<Integer>>> createListOfDepths(BinaryTreeNode<Integer> root){
		ArrayList<LinkedList<BinaryTreeNode<Integer>>> nodesList = new ArrayList<>();
		LinkedList<BinaryTreeNode<Integer>> rootList = new LinkedList<>();
		rootList.add(root);
		nodesList.add(rootList);
		addDepthLists(rootList,nodesList);
		return nodesList;
	}

	private void addDepthLists(LinkedList<BinaryTreeNode<Integer>> rootList,
			ArrayList<LinkedList<BinaryTreeNode<Integer>>> nodesList) {
		if(rootList.isEmpty())
			return;
		LinkedList<BinaryTreeNode<Integer>> tempList = new LinkedList<>();
		rootList.forEach(x->{
			if(x.left!=null)
				tempList.add(x.left);
			if(x.right!=null)
				tempList.add(x.right);
		});
		nodesList.add(tempList);
		addDepthLists(tempList,nodesList);
	}
	

	public static void main(String args[]){
		ListOfDepths listOfDepths = new ListOfDepths();
		MinimalTree minimalTreeNode = new MinimalTree();
		Integer[] values = {1,2,3,4,5,6};
		System.out.println(listOfDepths.createListOfDepths(minimalTreeNode.createMinimalTree(values)));
	}
}
