package ch2;

import ch2.LinkedListNode;

public class Solution25 {

	/**
	 * Algorithm: Simulation (no extra space)
	 * Time Complexity: O(n) 	Space Compexity: O(1)
	 * @param h1
	 * @param h2
	 * @return
	 */
	public static LinkedListNode sumLists(LinkedListNode h1, LinkedListNode h2) {
//		LinkedListNode rev_h1 = reverseLinkedList(h1);
//		LinkedListNode rev_h2 = reverseLinkedList(h2);
		
		int len_h1 = getLinkedListLength(h1);
		int len_h2 = getLinkedListLength(h2);
		LinkedListNode shrter = len_h1>len_h2 ? h2 : h1;
		LinkedListNode longer = len_h1>len_h2 ? h1 : h2;
		
		int c = 0;
		LinkedListNode ret = longer;
		LinkedListNode prev = null;
		while (longer != null) {
			if (shrter != null) {
				longer.val += shrter.val;
				shrter = shrter.next;
			}
			longer.val += c;
			c = longer.val / 10;
			longer.val %= 10;
			prev = longer;
			longer = longer.next;
		}
		if (c !=0 ) {
			LinkedListNode carry_node = new LinkedListNode(c);
			prev.next = carry_node;
		}
		
//		ret = reverseLinkedList(ret);
		return ret;
	}
	
	/**
	 * Get Linked List length
	 * @param head
	 * @return
	 */
	public static int getLinkedListLength(LinkedListNode head) {
		LinkedListNode curr = head;
		int len = 0;
		while (curr != null) {
			curr = curr.next;
			len++;
		}
		return len;
	}
	
	/**
	 * Reverse linked list with no extra space
	 * Time: O(n) Space: O(1)
	 * @param head
	 * @return
	 */
	public static LinkedListNode reverseLinkedList(LinkedListNode head) {
		LinkedListNode prev = null;
		LinkedListNode curr = head;
		while (curr != null) {
			LinkedListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
		 * Testing case: 
		 */
		int[] vals1 = {7, 1, 6};
		int[] vals2 = {5, 9, 3, 9, 9, 9};
		LinkedListNode list1 = createLinkedList(vals1);
		LinkedListNode list2 = createLinkedList(vals2);
		
		System.out.println("Original List: ");
		printLinkedList(list1);
		printLinkedList(list2);

		LinkedListNode ret = sumLists(list1, list2);
		System.out.println("Result List: ");
		printLinkedList(ret);
	}
}
