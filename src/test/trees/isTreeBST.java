package test.trees;

import test.trees.TreeUtil.Direction;

/*
 http://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
 Whether a given tree is BST or not
 There are multiple good methods - 
 Method1 - make use of the property that all the nodes in left subtree are smaller than current node value, 
 and right nodes are greater than current node
 Method 2 - check inorder traversal is sorted or not, the current node in inorder traversal 
 should be > than previous traversed node
 */
public class isTreeBST {

	public static void main(String[] args) {
		// int[] tree = { 3, 2, 5, 1, 4 };
		// System.out
		// .println(isBST(tree, 0, Integer.MIN_VALUE, Integer.MAX_VALUE));

		Node bst = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(
				5));
		Node nonBST = new Node(3, new Node(2, new Node(1), new Node(4)),
				new Node(5));
		BTreePrinter.printNode(bst);
		// System.out.println(isBSTInorderTraversal(nonBST));
		System.out.println(isBSTMinMax(bst, Integer.MIN_VALUE,
				Integer.MAX_VALUE));
	}

	static Node prevNode = null;

	static boolean isBSTMinMax(Node root, int min, int max) {
		System.out.println("root:" + root.value + ", left:"
				+ (root.left == null ? null : root.left.value) + ", right:"
				+ (root.right == null ? null : root.right.value) + ", min:" + min + ", max:" + max);
		if (root.value > min && root.value < max) {
			if (root.left == null || root.left != null && isBSTMinMax(root.left, min, root.value)) {
				if (root.right == null || root.right != null
						&& isBSTMinMax(root.right, root.value, max)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean isBSTInorderTraversal(Node root) {
		if (root == null) {
			return true;
		}

		if (!isBSTInorderTraversal(root.left)) {
			return false;
		}
		if (prevNode != null && prevNode.value >= root.value) {
			// bst property broken
			return false;
		}
		// set the previous node after visiting
		prevNode = root;
		if (!isBSTInorderTraversal(root.right)) {
			return false;
		}
		return true;
	}

	// static boolean isBST(int[] preorder, int preindex, int min, int max) {
	// // System.out.println(preindex + " " + min + " " + max);
	// if (TreeUtil.isLeaf(preorder, preindex) || preindex >= preorder.length) {
	// return true;
	// }
	//
	// if (preorder[preindex] > max || preorder[preindex] < min) {
	// return false;
	// } else {
	// boolean isLeftBST = false;
	// if (TreeUtil.isLeaf(preorder,
	// TreeUtil.getNodeIndex(preorder, preindex, Direction.LEFT))) {
	// isLeftBST = true;
	// } else {
	// isLeftBST = isBST(preorder, TreeUtil.getNodeIndex(preorder,
	// preindex, Direction.LEFT), min, preorder[preindex] - 1);
	// }
	//
	// boolean isRightBST = false;
	// if (TreeUtil.isLeaf(preorder,
	// TreeUtil.getNodeIndex(preorder, preindex, Direction.RIGHT))) {
	// isRightBST = true;
	// } else {
	// isRightBST = isBST(preorder, TreeUtil.getNodeIndex(preorder,
	// preindex, Direction.RIGHT), preorder[preindex] + 1, max);
	// }
	//
	// return isLeftBST && isRightBST;
	// }
	//
	// }
}
