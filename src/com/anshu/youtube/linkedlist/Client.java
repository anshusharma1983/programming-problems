package test.youtube.linkedlist;

public class Client {
	
	private static LinkedListService linkedListService = new LinkedListServiceImpl();

	public static void main(String[] args) {
		Node head = linkedListService.createList(5);
		linkedListService.printList(head);
		Node newHead = linkedListService.reverseWithRecursion(head);
//		Node newHead = linkedListService.reverseWithoutRecursion(head);
		linkedListService.printList(newHead);
	}
}
