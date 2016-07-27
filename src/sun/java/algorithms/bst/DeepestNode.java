package sun.java.algorithms.bst;

import java.util.*;

public class DeepestNode {
	static class Node {
		Node left;
		Node right;
		int value;

		public Node(int value) {
			this.value = value;
		}
	}

	private static List<Node> findDeepestNodes(Node root) {
		Object[] levelNodes = new Object[2];
		levelNodes[0] = 0;
		levelNodes[1] = new ArrayList<Node>();
		findDeepestNodes(root, 1, levelNodes);
		return (List<Node>) levelNodes[1];
	}

	private static void findDeepestNodes(Node root, int level,
			Object[] levelNodes) {
		if (root == null)
			return;
		if ((Integer) levelNodes[0] <= level) {
			if ((Integer) levelNodes[0] < level)
				((List<Node>) levelNodes[1]).clear();
			levelNodes[0] = level;
			((List<Node>) levelNodes[1]).add(root);
		}
		findDeepestNodes(root.left, level + 1, levelNodes);
		findDeepestNodes(root.right, level + 1, levelNodes);
	}

	public static void main(String[] args) {
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(8);
		Node g = new Node(6);
		Node h = new Node(7);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.right = f;
		f.left = g;
		f.right = h;

		List<Node> nodes = findDeepestNodes(a);
		for (Node node : nodes) {
			System.out.print(node.value + ", ");
		}
	}
}
