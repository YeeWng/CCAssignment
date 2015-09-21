package ch2;

import ch2.LinkedListNode;

public class Solution22 {

	/**
	 * Algorithm: two pointers one is ahead k nodes to the other
	 * Time: O(n)	Space: O(1)
	 * @param head
	 * @param k
	 * @return
	 */
	public static LinkedListNode findKthtoLast(LinkedListNode head, int k) {
		LinkedListNode p1 = head;
		LinkedListNode p2 = head;
		
		// Move p1 k nodes ahead to p2
		for (int i = 0; i < k; i++) {
			if (p1 == null) 
				return null; // Out of bounds
			p1 = p1.next;
		}
		
		// Move them at the same pace. When p1 hits the end, 
		//  p2 will be at the right element.
		while (p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
	  	}
	  	return p2;
	}
	
	/**
	 * Print out Linked list
	 * @param head
	 */
	public static void  printLinkedList(LinkedListNode head){		

		while (head != null) {
			
			if (head.next != null){
				System.out.print(head.val + " -> ");
			} else {
				System.out.print(head.val);
			}
			head = head.next;
		}
		System.out.println();
	}
	
	/**
	 * Create Linked list
	 * Time: O(n) Space: O(n)
	 * @param arr
	 * @return
	 */
	public static LinkedListNode createLinkedList(int[] arr) {
		
		LinkedListNode head = null, curr = null;
		for (int i = 0; i < arr.length; i++) {
			LinkedListNode node = new LinkedListNode(arr[i]);
			if (i == 0) {
				head = node;
				curr = head;
			} else {
				curr.next = node;
				curr = curr.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases.
		 * Case 1: 2-->4-->1-->3-->2-->4
		 */
		int[] arr1 = {2, 4, 1, 3, 2, 4};
		LinkedListNode head = createLinkedList(arr1);
		System.out.println("Original linkedlists: ");
		printLinkedList(head);
	
		int[] k_arr = {0, 1, 2, 3, 4, 5, 6, 7, 8};
		for (int k : k_arr) {
			LinkedListNode ret = findKthtoLast(head, k);
			if (ret != null) {
				System.out.println("The " + k + "th to last elements is: " + ret.val);
				printLinkedList(ret);
			}
			else
				System.out.println("K is out of range.");
		}
		
	}

}
