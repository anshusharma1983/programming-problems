package test.trees;

/*
 http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-tree-set-2-using-parent-pointer/
 http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/ 
 A O(h) time and O(1) Extra Space Solution
 If both nodes are at same level and if we traverse up using parent pointers of both nodes, 
 the first common node in the path to root is lca.
 The idea is to find depths of given nodes and move up the deeper node pointer by the difference between depths. 
 Once both nodes reach same level, traverse them up and return the first common node.
 */
public class LowestCommonAncestor {
	public static void main(String[] args) {
		// Node root = new Node(3, new Node(1), new Node(2));
		Node root = new Node(20, new Node(8, new Node(4), new Node(12,
				new Node(10), new Node(14))), new Node(22));
		// TreeUtil.printTreeBFS(root);
		// System.out.println(findCommonAncestorWithParentReference(root, 4,
		// 10));
		System.out.println(findCommonAncestorWithoutParent(root, 4, 10));
	}

	static int findCommonAncestorWithParentReference(Node root, int a1, int b1) {
		Node a = TreeUtil.findNodeInBST(root, a1);
		Node b = TreeUtil.findNodeInBST(root, b1);
		int h1 = TreeUtil.getHeight(a);
		int h2 = TreeUtil.getHeight(b);

		if (h1 > h2) {
			// move a up by difference
			int diff = h1 - h2;
			while (diff > 0) {
				a = a.parent;
				diff--;
			}
		} else if (h1 < h2) {
			int diff = h2 - h1;
			// move b up by difference
			while (diff > 0) {
				b = b.parent;
				diff--;
			}
		}
		while (a.value != b.value) {
			a = a.parent;
			b = b.parent;
		}
		return a.value;
	}

	/**
	 * O(n) as tree is traversed only once in bottom up fashion. Can be
	 * optimized further (method 3)
	 * http://www.geeksforgeeks.org/lowest-common-ancestor
	 * -in-a-binary-search-tree/
	 * 
	 * @param root
	 * @param a1
	 * @param b1
	 * @return
	 */
	static Integer findCommonAncestorWithoutParent(Node root, int a1, int b1) {
		if (root == null) {
			return null;
		}

		if (root.value == a1 || root.value == b1) {
			return root.value;
		}

		Integer leftLCA = findCommonAncestorWithoutParent(root.left, a1, b1);
		Integer rightLCA = findCommonAncestorWithoutParent(root.right, a1, b1);

		if (leftLCA != null && rightLCA != null) {
			return root.value;
		}
		return (leftLCA != null) ? leftLCA : rightLCA;
	}
}
