package test.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * 
 * @author hix-test
 *
 */
public class InorderTraversal {
	public static void main(String[] args) {
		Node root = new Node(1, new Node(2, new Node(4), new Node(5)),
				new Node(3));
		inorderTraversal(root);
		List<Integer> list = new ArrayList();
		inorderTraversalUsingRecursion(root, list);
		System.out.println();
		for (Integer i : list) {
			System.out.print(" " + i);
		}
	}

	static void inorderTraversal(Node node) {
		Stack<Node> stack = new Stack<Node>();
		while (node != null) {
			stack.push(node);
			node = node.left;
		}

		while (!stack.isEmpty()) {
			node = stack.pop();
			System.out.print(" " + node.value);
			if (node.right != null) {
				node = node.right;
				while (node != null) {
					stack.push(node);
					node = node.left;
				}
			}
		}
	}

	static void inorderTraversalUsingRecursion(Node node,
			List<Integer> emptyList) {
		if (node == null)
			return;
		if (node.left != null) {
			inorderTraversalUsingRecursion(node.left, emptyList);
		}
		emptyList.add((Integer) node.value);
		if (node.right != null) {
			inorderTraversalUsingRecursion(node.right, emptyList);
		}
	}
}
