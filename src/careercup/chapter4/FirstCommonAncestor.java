package careercup.chapter4;

public class FirstCommonAncestor {
	
	public static BinaryTreeNode<Integer> commonAncestorWithParent(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q){
		while((p!=null && !p.isVisited) || (q!=null &&!q.isVisited)){
			if(p!=null){
			p.setVisited(true);
			p = p.parent;
			}
			if(q!=null){
			q.setVisited(true);
			q = q.parent;
			}
			if(p!=null && p.isVisited())
				return p;
			if(q!=null && q.isVisited())
				return q;
		}
		return null;
	}
	
	public static BinaryTreeNode<Integer> commonAncestor(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p, BinaryTreeNode<Integer> q){
		if(!covers(root,p) || !covers(root,q)){
			return null;
		}
		return commonAncestorHelper(root,p,q);
	}
	
	private static BinaryTreeNode<Integer> commonAncestorHelper(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> p,
			BinaryTreeNode<Integer> q) {
		if(root==null)
			return null;
		if(p==root || q==root)
			return root;
		boolean is_P_LeftSide = covers(root.left,p);
		boolean is_Q_LeftSide = covers(root.left,q);
		if(is_P_LeftSide!=is_Q_LeftSide){
			return root;
		}
		BinaryTreeNode<Integer> childNode = is_P_LeftSide?root.left:root.right;
		return commonAncestorHelper(childNode,p,q);
	}

	private static boolean covers(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
		if(root==node)
			return true;
		if(root==null)
			return false;
		return covers(root.left,node)  || covers(root.right,node);
	}

	public static void main(String args[]){
		MinimalTree minimalTreeNode = new MinimalTree();
		Integer[] values = {1,2,3,5,6,7,8,9};
		BinaryTreeNode<Integer> root = minimalTreeNode.createMinimalTree(values);
		System.out.println(commonAncestor(root,root.right.left,root.right.right));
	}

}
