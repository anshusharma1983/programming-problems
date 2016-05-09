package test.trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, new Node(4), new Node(5)),
				new Node(3));
		BTreePrinter.printNode(root);
		printLevelOrder(root);
	}

	static void printLevelOrder(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			System.out.print(" " + node.value);
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}
}
