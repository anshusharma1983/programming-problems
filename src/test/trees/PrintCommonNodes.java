package test.trees;

import java.util.ArrayList;
import java.util.List;

import test.list.ListUtil;

public class PrintCommonNodes {
	public static void main(String[] args) {
		Node tree1 = new Node(5, new Node(1, new Node(0), new Node(4)),
				new Node(10, new Node(7, null, new Node(9)), null));
		Node tree2 = new Node(10, new Node(7, new Node(4), new Node(9)),
				new Node(20));

		List<Integer> inorder1 = new ArrayList<Integer>();
		List<Integer> inorder2 = new ArrayList<Integer>();
		InorderTraversal.inorderTraversalUsingRecursion(tree1, inorder1);
		InorderTraversal.inorderTraversalUsingRecursion(tree2, inorder2);
		System.out.println("tree1:");
		BTreePrinter.printNode(tree1);
		System.out.println("tree2");
		BTreePrinter.printNode(tree2);
//		ListUtil.printList(inorder1);
//		ListUtil.printList(inorder2);
		printCommon(inorder1, inorder2);
	}

	private static void printCommon(List<Integer> inorder1,
			List<Integer> inorder2) {
		int i = 0, j = 0;
		System.out.println("Common elements:");
		while (i < inorder1.size() && j < inorder2.size()) {
			if (inorder1.get(i) == inorder2.get(j)) {
				System.out.print(" " + inorder1.get(i));
				i++;
				j++;
			} else if (inorder1.get(i) < inorder2.get(j)) {
				i++;
			} else {
				j++;
			}
		}
	}
}
