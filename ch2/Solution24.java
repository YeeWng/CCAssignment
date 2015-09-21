package ch2;

import ch2.LinkedListNode;

public class Solution24 {
	
	/**
	 * Algorithm: Like quick sort certain step 
	 *  	(according to the pivot x then just move current node to head and tail)
	 *  Time: O(n)	Space: O(1)
	 * @param head	Linked list head
	 * @param x		pivot value
	 * @return
	 */
	public static LinkedListNode partition(LinkedListNode head, int x) {
		// edge case
		if (head == null) return head;
		
		LinkedListNode p = head;
		LinkedListNode q = head;
		LinkedListNode curr = head;
		while (curr != null) {
			LinkedListNode next = curr.next;
			if (curr.val < x) {
				curr.next = p;
				p = curr;
//				curr.next = p.next;
//				p.next = curr;
			} else {
				q.next = curr;
				q = curr;
			}
			curr = next;
		}
		q.next = null;
		
		return p;
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
		 * Testing case
		 */
		int[][] vals = {{3, 5, 8, 5, 10, 2, 1}, 
						{10, 1}, {10} };
		for (int[] val : vals) {
			LinkedListNode list = createLinkedList(val);
			System.out.println("Original list: ");
			printLinkedList(list);
	
			LinkedListNode ret = partition(list, 5);
			System.out.println("Result list: ");	
			printLinkedList(ret);
		}
	}

}
