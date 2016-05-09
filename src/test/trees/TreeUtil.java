package test.trees;

import java.util.LinkedList;
import java.util.Queue;

public class TreeUtil {
	public enum Direction {
		LEFT, RIGHT
	};

	static Node findNodeInBST(Node root, int value) {
		Node temp = root;
		while (temp != null) {
			if (value == temp.value) {
				return temp;
			} else if (value > temp.value) {
				temp = temp.right;
			} else {
				temp = temp.left;
			}
		}
		return null;
	}

	static void printTreeBFS(Node root) {
		if (root == null) {
			System.out.println("Don't pass null here");
			return;
		}
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.remove();
			if (node.left != null)
				queue.add(node.left);
			if (node.right != null)
				queue.add(node.right);
			System.out.print(node.value + " ");
		}
		System.out.println();
	}

	static Integer getNodeIndex(int[] tree, int i, Direction direction) {
		if (direction == Direction.LEFT) {
			int leftindex = 2 * i + 1;
			if (leftindex < tree.length) {
				return leftindex;
			}
		} else if (direction == Direction.RIGHT) {
			int rightindex = 2 * i + 2;
			if (rightindex < tree.length) {
				return rightindex;
			}
		}
		return -1;
	}

	static Integer getNodeValue(int[] tree, int i, Direction direction) {
		int index = getNodeIndex(tree, i, direction);
		if (index > 0) {
			return tree[index];
		}
		return null;
	}

	static boolean isLeaf(int[] tree, int i) {
		int n = tree.length;
		if (i < 0 || i >= tree.length) {
			return true;
		}
		if (i >= (n + 1) / 2)
			return true;
		return false;
	}

	public static void main(String[] args) {
		int[] tree = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(getNodeValue(tree, 0, Direction.LEFT));
		System.out.println(getNodeValue(tree, 0, Direction.RIGHT));
		for (int i = 0; i < tree.length; i++) {
			System.out.println("leaf " + tree[i] + ":" + isLeaf(tree, i));
		}
	}

	public static int getHeight(Node a) {
		int height = 0;
		while (a.parent != null) {
			a = a.parent;
			height++;
		}
		return height;
	}
}
