package test.youtube.linkedlist;

public class LinkedListServiceImpl implements LinkedListService {

	@Override
	public Node createList(int size) {
		Node head = new Node(1);
		Node t = head;
		for (int i = 2; i <= size; i++) {
			t.next = new Node(i);
			t = t.next;
		}
		return head;
	}

	@Override
	public void printList(Node head) {
		while (head != null) {
			System.out.print(" " + head.value);
			head = head.next;
		}
		System.out.println();
	}

	@Override
	public Node reverseWithoutRecursion(Node head) {
		Node prev, curr, next;
		prev = null;
		curr = head;
		next = head.next;
		while (curr != null) {
			curr.next = prev;
			prev = curr;
			curr = next;
			if (next != null) {
				next = next.next;
			}
		}
		return prev;
	}

	Node newHead = null;
	@Override
	public Node reverseWithRecursion(Node head) {
		reverseWithRecursionInternal(head);
		return newHead;
	}
	
	public Node reverseWithRecursionInternal(Node head) {
		if (head.next == null) {
			newHead = head;
			return head;
		}
		Node next = reverseWithRecursionInternal(head.next);
		next.next = head;
		head.next = null;
		return head;
	}

	@Override
	public void printWithRecursion(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(" " + head.value);
		printWithRecursion(head.next);
	}

	@Override
	public void printReverseWithRecursion(Node head) {
		if (head == null) {
			return;
		}
		printReverseWithRecursion(head.next);
		System.out.print(" " + head.value);
	}
}
