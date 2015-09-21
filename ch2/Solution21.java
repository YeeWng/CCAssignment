package ch2;

import java.util.HashSet;
import ch2.LinkedListNode;

public class Solution21 {
	
	/**
	 * Algorithm: Simulation
	 * Time: O(n) 	Space: O(1)
	 * @param head
	 * @return
	 */
	public static LinkedListNode deleteDups(LinkedListNode head) {
		
		// Edge case 1
		if (head == null) return null;
		
		// Edge case 2
		if (head.next == null) return head;
		
		HashSet<Integer> set = new HashSet<Integer>();
		
		LinkedListNode curr = head;
		LinkedListNode prev = null;
		while (curr != null) {
			if (set.add(curr.val))
				prev = curr;
			else
				prev.next = curr.next;
			
			curr = curr.next;
		}
		return head;
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
	
	public static void main(String[] args){
		
		/**
		 * Testing cases:
		 */
		//Case 1: 2-->4-->1-->3-->2-->4
		int[] arr1 = {2, 4, 1, 3, 2, 4};
		LinkedListNode head1 = createLinkedList(arr1);
		
		//Case 2: 2-->4-->1-->3-->6
		int[] arr2 = {2, 4, 1, 3, 6};
		LinkedListNode head2 = createLinkedList(arr2);
		
		System.out.println("Original lists: ");
		printLinkedList(head1);
		printLinkedList(head2);
	
		LinkedListNode result1 = deleteDups(head1);
		LinkedListNode result2 = deleteDups(head2);
		 
		System.out.println("Result lists: ");
		printLinkedList(result1);
		printLinkedList(result2);
	}
}
