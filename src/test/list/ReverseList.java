package test.list;

public class ReverseList {
	static Node newHead;
	static class Node {
		int value;
		Node next;

		public Node(int i) {
			this.value = i;
			next = null;
		}
	}

	public static void printList(Node head) {
		while (head != null) {
			System.out.print(head.value);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		Node head = createList(5);
		printList(head);
		reverseList(head);
		System.out.println("New list: ");
		printList(newHead);
	}

	private static Node reverseList(Node head) {
		if (head.next == null) {
			newHead = head;
			return head;
		}
		Node next = reverseList(head.next);
		next.next = head;
		head.next = null;
		return head;
	}

	private static Node createList(int i) {
		Node head = new Node(1); 
		Node previous = head;
		for (int j = 2 ; j <= i ; j++) {
			Node current = new Node(j);
			previous.next = current;
			previous = previous.next;
		}
		return head;
	}

}
