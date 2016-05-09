package test.trees;

public class Node {
	Integer value;
	Node left = null;
	Node right = null;
	Node parent = null;

	public Node(Integer value) {
		this.value = value;
	}

	public Node(Integer value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
		if (left != null)
			left.parent = this;
		if (right != null)
			right.parent = this;
	}
}
