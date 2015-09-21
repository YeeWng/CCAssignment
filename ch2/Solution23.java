package ch2;

import ch2.LinkedListNode;

public class Solution23 {
	
	/**
	 * Algorithm: runner techniques
	 * Time: O(n)	Space: O(1)
	 * @param head
	 */
	public static void deleteMiddleNode(LinkedListNode head){
		// Edge case
		if(head == null || head.next == null) return ;
		
		// Runner
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		LinkedListNode slow_prev = null;
		
		while(fast.next != null && fast.next.next != null){
			slow_prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		slow_prev.next = slow.next;
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
		 * Assumption: the linked list size is an odd number.
		 * Testing cases: 
		 */
		int[][] vals = {{3, 5, 8, 5, 10, 2, 1}, 
						{1, 2, 3, 4, 5}, {1}, {1, 2, 3}, {}};
		for (int[] val : vals) {
			LinkedListNode list = createLinkedList(val);
			System.out.println("Original list: ");
			printLinkedList(list);

			deleteMiddleNode(list);
			System.out.println("Result list: ");	
			printLinkedList(list);
		}

	}

}
