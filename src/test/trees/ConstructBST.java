package test.trees;

/*
 * http://www.geeksforgeeks.org/construct-tree-from-given-inorder-and-preorder-traversal/
 * http://javabypatel.blogspot.in/2015/08/construct-binary-tree-from-inorder-and-level-order-traversals.html -- better explanations 
 * http://www.geeksforgeeks.org/construct-tree-inorder-level-order-traversals/
 */
public class ConstructBST {
	static int preIndex = 0;

	public static void main(String[] args) {
		// for in and pre
		// int inorder[] = new int[] { 4, 2, 5, 1, 6, 3 };
		// int preorder[] = new int[] { 1, 2, 4, 5, 3, 6 };

		// Node root = constructBSTFromPreOrderAndInOrder(inorder, preorder, 0,
		// inorder.length - 1);

		// for in and level
		int inorder[] = { 4, 8, 10, 12, 14, 20, 22 };
		int level[] = { 20, 8, 22, 4, 12, 10, 14 };
		int preorder[] = { 10, 5, 1, 7, 40, 50 };
		int postorder[] = { 1, 7, 5, 50, 40, 10 };
		Node root = null;
		root = constructBSTFromPreOrder(preorder, new PreRes(0),
		 Integer.MIN_VALUE, Integer.MAX_VALUE);
		BTreePrinter.printNode(root);
		root = constructBSTFromPostOrder(postorder, new PostRes(
				postorder.length - 1), Integer.MIN_VALUE, Integer.MAX_VALUE);
		BTreePrinter.printNode(root);
		// Node root = constructBSTFromInAndLevelOrders(inorder, level, 0,
		// inorder.length - 1);
		// BTreePrinter.printNode(root);
	}

	static Node constructBSTFromInAndLevelOrders(int[] inorder, int[] level,
			int inStart, int inEnd) {
		if (inStart > inEnd) {
			return null;
		}
		boolean found = false;
		int inIndex = -1;
		Node node = null;
		for (int i = 0; i < level.length; i++) {
			for (int j = inStart; j <= inEnd; j++) {
				if (level[i] == inorder[j]) {
					node = new Node(level[i]);
					found = true;
					inIndex = j;
					break;
				}
			}
			if (found == true)
				break;
		}
		// if (inStart == inEnd) {
		// return node;
		// }

		node.left = constructBSTFromInAndLevelOrders(inorder, level, inStart,
				inIndex - 1);
		node.right = constructBSTFromInAndLevelOrders(inorder, level,
				inIndex + 1, inEnd);
		return node;
	}

	/**
	 * Inorder sequence: D B E A F C <br>
	 * Preorder sequence: A B D E C F
	 * 
	 * In a Preorder sequence, leftmost element is the root of the tree. So we
	 * know ‘A’ is root for given sequences. By searching ‘A’ in Inorder
	 * sequence, we can find out all elements on left side of ‘A’ are in left
	 * subtree and elements on right are in right subtree. So we know below
	 * structure now.
	 */
	static Node constructBSTFromPreOrderAndInOrder(int[] inorder,
			int[] preorder, int inStart, int inEnd) {
		// System.out.println("inStart:" + inStart + ", inEnd:" + inEnd
		// + ", preIndex:" + preIndex);
		if (inStart > inEnd) {
			return null;
		}
		Node node = new Node(preorder[preIndex++]);

		/* If this node has no children then return */
		if (inStart == inEnd) {
			return node;
		}

		// System.out.println("created node:" + node.value);
		int inIndex = search(inorder, node.value, inStart, inEnd);
		node.left = constructBSTFromPreOrderAndInOrder(inorder, preorder,
				inStart, inIndex - 1);
		// if (node.left != null)
		// System.out.println("added " + node.left.value + " to left of "
		// + node.value);
		node.right = constructBSTFromPreOrderAndInOrder(inorder, preorder,
				inIndex + 1, inEnd);
		// if (node.right != null)
		// System.out.println("added " + node.right.value + " to right of "
		// + node.value);
		return node;
	}

	static class PreRes {
		int preIndex;

		public PreRes(int preIndex) {
			this.preIndex = preIndex;
		}
	}

	static class PostRes {
		int postIndex;

		public PostRes(int postIndex) {
			this.postIndex = postIndex;
		}
	}
	
	// remember to create left node first and the right, spent hours to find this bug in postorder
	static Node constructBSTFromPreOrder(int[] preorder, PreRes res, int min,
			int max) {
		Node node = null;
		if (res.preIndex < preorder.length) {
			System.out.println("index: " + res.preIndex + ", key:" + preorder[res.preIndex] + ", min:" + min + ", max:" + max);
			int key = preorder[res.preIndex];
			if (key > min && key < max) {
				node = new Node(key);
				res.preIndex = res.preIndex + 1;
				node.left = constructBSTFromPreOrder(preorder, res, min, key);
				node.right = constructBSTFromPreOrder(preorder, res, key, max);
			}
		}
		return node;
	}
	
	/*
	 * Remember to create right node first then left !! Spent hours to find this
	 */
	static Node constructBSTFromPostOrder(int[] postorder, PostRes res,
			int min, int max) {
		Node node = null;
		if (res.postIndex >= 0) {
			System.out.println("index: " + res.postIndex + ", key:" + postorder[res.postIndex] + ", min:" + min + ", max:" + max);
			int key = postorder[res.postIndex];
			if (key > min && key < max) {
				node = new Node(key);
				res.postIndex = res.postIndex - 1;
				node.right = constructBSTFromPostOrder(postorder, res, key, max);
				node.left = constructBSTFromPostOrder(postorder, res, min, key);
			}
		}
		return node;
	}

	private static int search(int[] preorder, int value, int inStart, int inEnd) {
		for (int i = inStart; i <= inEnd; i++) {
			if (preorder[i] == value)
				return i;
		}
		return -1;
	}
}
