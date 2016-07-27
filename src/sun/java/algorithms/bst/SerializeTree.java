package sun.java.algorithms.bst;

import java.util.StringTokenizer;

class TreeNode{
	int val;
	TreeNode left, right;
	TreeNode(int val){
		this.val = val;
	}
}

public class SerializeTree{
	public String serialize(TreeNode root){
		StringBuilder sb = new StringBuilder();
		serialize(root, sb);
		return sb.toString();
	}

	private void serialize(TreeNode x, StringBuilder sb){
		if (x == null) {
			sb.append("# ");
		} else {
			sb.append(x.val + " ");
			serialize(x.left, sb);
			serialize(x.right, sb);
		}
	}

	public TreeNode deserialize(String s){
		if (s == null || s.length() == 0) return null;
		StringTokenizer st = new StringTokenizer(s, " ");
		return deserialize(st);
	}

	private TreeNode deserialize(StringTokenizer st){
		if (!st.hasMoreTokens())
			return null;
		String val = st.nextToken();
		if (val.equals("#"))
			return null;
		TreeNode root = new TreeNode(Integer.parseInt(val));
		root.left = deserialize(st);
		root.right = deserialize(st);
		return root;
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(8);
		TreeNode g = new TreeNode(6);
		TreeNode h = new TreeNode(7);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.right = f;
		f.left = g;
		f.right = h;

		SerializeTree temp =  new SerializeTree();
		String serializeData =  temp.serialize(a);
		TreeNode node = temp.deserialize(serializeData);
		
		
		System.out.println(serializeData);
	}
}