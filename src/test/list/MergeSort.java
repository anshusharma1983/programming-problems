package test.list;

public class MergeSort {

	static class Node {
		int value;
		Node next;

		public Node(int val) {
			this.value = val;
			next = null;
		}
	}

	public static Node createList(int[] a) {
		Node head = new Node(a[0]);
		Node nextNode = head;
		for (int i = 1; i < a.length; i++) {
			nextNode.next = new Node(a[i]);
			nextNode = nextNode.next;
		}
		return head;
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node list = createList(new int[] { 2, 3, 5, 1, 4 });
		printList(list);
		Node first = null, second = null;
		splitList(list, first, second);
		printList(first);
		printList(second);
	}

	public static Node mergeSort(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		// 1. Divide in 2
		Node first = null, second = null;
		splitList(head, first, second);
		first = mergeSort(first);
		second = mergeSort(second);
		head = mergeSortCombine(first, second);
		return head;
	}

	private static void splitList(Node head, Node first, Node second) {
		first = second = head.next;
		Node previous = null;
		previous = head;
		while (second.next != null) {
			first = first.next;
			previous = previous.next;
			second = second.next;
			if (second.next != null) {
				second = second.next;
			}
		}
		previous.next = null;
		second = first;
		first = head;
	}

	private static Node mergeSortCombine(Node first, Node second) {

		return null;
	}

}
