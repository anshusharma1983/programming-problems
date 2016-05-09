package test.misc;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	/**
	 * Traversals <br>
	 * Inorder -> left root right> <br>
	 * Preorder -> root left right <br>
	 * Inorder sequence: D B E A F C <br>
	 * Preorder sequence: A B D E C F
	 * 
	 * @author Anshu
	 * 
	 */

	static class Node {
		Integer val;
		Node left = null;
		Node right = null;

		public Node(Integer val) {
			this.val = val;
		}
	}

	public static void prob1createTreeWithInorderAndPreorderArrays() {
		// Integer[] arr = {4, 2, 5, 1, 6, 3 };
		// printArr(getArray(arr, true, 1));
		// Node root = dummyTree();
		// printTree(root);
		Node root = createTreeWithInorderAndPreorderArrays(new Integer[] { 4,
				2, 5, 1, 6, 3 }, new Integer[] { 1, 2, 3, 4, 5, 6 }, 0);
		printTree(root);
	}

	public static void prob2GetInAndLevelOrderTraversal() {
		/**
		 * Construct a tree from Inorder and Level order traversal <br>
		 * in[] = {4, 8, 10, 12, 14, 20, 22}; <br>
		 * level[] = {20, 8, 22, 4, 12, 10, 14}; <br>
		 * Output: Construct the tree represented by the two arrays. For the
		 * above two arrays, the constructed tree is shown in the diagram on
		 * right side
		 */
		Integer in[] = { 4, 8, 10, 12, 14, 20, 22 };
		Integer level[] = { 20, 8, 22, 4, 12, 10, 14 };
		Node tree = createNode(in, level);
		printTree(tree);
	}

	public static void main(String[] args) {
		prob2GetInAndLevelOrderTraversal();
	}

	/**
	 * working fine
	 * @param in
	 * @param level
	 * @return
	 */
	private static Node createNode(Integer[] in,
			Integer[] level) {
		printArr(level);
		Node root = new Node(level[0]);
		if (in.length == 1) {
			return root;
		}
		Integer rootVal = level[0];
		Integer left[] = getArray(in, true, rootVal);
		Integer leftLevel[] = getLevel(level, left);
		Integer right[] = getArray(in, false, rootVal);
		Integer rightLevel[] = getLevel(level, right);
		Node leftNode = null, rightNode = null;
		if (left != null) {
			leftNode = createNode(left, leftLevel);
			root.left = leftNode;
		}
		if (right != null) {
			rightNode = createNode(right, rightLevel);
			root.right = rightNode;
		}
		return root;
	}

	private static Integer[] getLevel(Integer[] level, Integer[] in) {
		Integer[] subLevel = new Integer[in.length];
		int index = 0;
		for (int i = 0; i < level.length; i++) {
			if (isPresent(in, level[i])) {
				subLevel[index++] = level[i];
			}
		}
		return subLevel;
	}

	private static boolean isPresent(Integer[] in, Integer integer) {
		for (int i = 0; i< in.length; i++) {
			if (integer == in[i]) {
				return true;
			}
		}
		return false;
	}

	private static void printTree(Node root) {
		if (root == null) {
			return;
		} else {
			printTree(root.left);
			System.out.print(root.val + " ");
			printTree(root.right);
		}
	}

	private static Node dummyTree() {
		Node root = new Node(2);
		root.left = new Node(1);
		root.right = new Node(3);
		return root;
	}

	private static void printArr(Integer[] arr) {
		if (arr == null) {
			System.out.println("No input");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static Node createTreeWithInorderAndPreorderArrays(Integer[] inOrder,
			Integer[] preOrder, Integer preOrderIndex) {
		if (inOrder == null || preOrder == null
				|| preOrderIndex >= preOrder.length || preOrderIndex < 0) {
			return null;
		}
		System.out.println("processing root" + inOrder[0]);
		Node root = new Node(inOrder[0]);
		Integer[] leftArray = getArray(preOrder, true, inOrder[0]);
		Integer[] rightArray = getArray(preOrder, false, inOrder[0]);
		System.out.print("Left array ");
		printArr(leftArray);
		System.out.print("Right array ");
		printArr(rightArray);
		Node leftNode = null, rightNode = null;
		if (preOrderIndex < preOrder.length) {
			leftNode = createTreeWithInorderAndPreorderArrays(leftArray,
					preOrder, preOrderIndex + 1);
			rightNode = createTreeWithInorderAndPreorderArrays(rightArray,
					preOrder, preOrderIndex + 1);
			System.out.println("root [" + root.val + "], left ["
					+ ((leftNode == null) ? "" : leftNode.val) + "], right ["
					+ (rightNode == null ? "" : rightNode.val) + "]");
		}
		root.left = leftNode;
		root.right = rightNode;
		return root;
	}

	private static Integer[] getArray(Integer[] inOrder, boolean left,
			Integer pivot) {
		Integer[] array;
		Integer leftBound = -1, rightBound = -1;
		if (left) {
			leftBound = 0;
		} else {
			rightBound = inOrder.length - 1;
		}
		for (int i = 0; i < inOrder.length; i++) {
			if (pivot == inOrder[i]) {
				if (left) {
					rightBound = i - 1;
				} else {
					leftBound = i + 1;
				}
			}
		}
		if (leftBound >= 0 && rightBound < inOrder.length
				&& (rightBound - leftBound) >= 0) {
			return Arrays.copyOfRange(inOrder, leftBound, rightBound + 1);
		}
		return null;
	}

	/**
	 * compare whether BST are equal or not
	 * 
	 * @param root
	 * @return
	 */
	static boolean isBST(Node root) {
		if (root == null) {
			return true;
		}

		if (root.right != null && root.val > root.right.val) {
			return false;
		}
		if (root.left != null && root.val <= root.left.val) {
			return false;
		}
		return (isBST(root.left) && isBST(root.right));
	}

	/**
	 * compare tree bfs
	 * 
	 * @param tree1
	 * @param tree2
	 * @return
	 */
	private static Boolean isEqual(Node tree1, Node tree2) {
		if ((tree1 == null && tree2 != null)
				|| (tree1 != null && tree2 == null)) {
			return false;
		}
		if (tree1 == null && tree2 == null) {
			return true;
		}

		// Both of the trees are not null
		if (!tree1.val.equals(tree2.val)) {
			return false;
		}

		Queue<Node> tree1Nodes = new LinkedList<Node>();
		Queue<Node> tree2Nodes = new LinkedList<Node>();
		tree1Nodes.add(tree1.left);
		tree1Nodes.add(tree1.right);
		tree2Nodes.add(tree2.left);
		tree2Nodes.add(tree2.right);
		while (!tree1Nodes.isEmpty() || !tree2Nodes.isEmpty()) {
			if (tree1Nodes.isEmpty() || tree2Nodes.isEmpty()) {
				return false;
			}

			Node tree1Node = tree1Nodes.poll();
			Node tree2Node = tree2Nodes.poll();
			if (!tree1Node.val.equals(tree2Node.val)) {
				return false;
			}
			if (tree1Node.left != null) {
				tree1Nodes.add(tree1Node.left);
			}
			if (tree1Node.right != null) {
				tree1Nodes.add(tree1Node.right);
			}

			if (tree2Node.left != null) {
				tree2Nodes.add(tree2Node.left);
			}
			if (tree2Node.right != null) {
				tree2Nodes.add(tree2Node.right);
			}
		}
		return true;
	}

}
