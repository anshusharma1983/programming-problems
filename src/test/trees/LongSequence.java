package test.trees;

import java.util.ArrayList;
import java.util.List;

public class LongSequence {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value, Node left, Node right) {
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public static void main(String[] args) {
		Node five = new Node(5, null, null);
		Node four = new Node(4, null, five);
		Node three = new Node(3, four, null);
		Node seven = new Node(7, null, null);
		Node two = new Node(2, seven, null);
		Node head = new Node(6, two, three);
		System.out.println(getMaxLength(head));
	}

	static int maxLen = 0;

	//wrong, it should be parent length = max of left or right child length
	static int getMaxLength(Node n) {
		if (n == null) {
			return 0;
		}
		if (n.left == null && n.right == null) {
			return 1;
		}

		List<Node> children = new ArrayList();
		if (n.left != null)
			children.add(n.left);

		if (n.right != null)
			children.add(n.right);

		for (Node ch : children) {
			System.out.println("Iterating on node: " + n.value + "'s  child: " + ch.value);
			if (ch.value != n.value + 1) {
				getMaxLength(ch);
				return 1;
			} else {
				int len = 1 + getMaxLength(ch);
				System.out.println("length for node: " + n.value + " is :" + len);
				if (len > maxLen) {
					maxLen = len;
				}
				return len;
			}
		}
		return -1;
	}
}
