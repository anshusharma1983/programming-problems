package test.youtube.linkedlist;

/**
 * 
 * @author Anshu
 * 
 */
public interface LinkedListService {

	/**
	 * Create a linked list of given size
	 * 
	 * @param size
	 * @return head node
	 */
	Node createList(int size);

	/**
	 * Print the linked list
	 * 
	 * @param head
	 */
	void printList(Node head);
	
	void printWithRecursion(Node head);
	
	void printReverseWithRecursion(Node head);

	/**
	 * Reverse a linked list without recursion, return the new head
	 * 
	 * @param head
	 * @return
	 */
	Node reverseWithoutRecursion(Node head);

	/**
	 * Reverse a linked list using recursion, return the new head
	 * 
	 * @param head
	 * @return
	 */
	Node reverseWithRecursion(Node head);

}
