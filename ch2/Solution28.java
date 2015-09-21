package ch2;

import ch2.LinkedListNode;

public class Solution28 {
	
	/**
	 * Algorithm: Runner Tech.
	 * Time Complexity: O(n)	Space Complexity: O(1)
	 * @param head
	 * @return
	 */
	public static LinkedListNode findLoopBeginning(LinkedListNode head) {
		LinkedListNode slow = head;
		LinkedListNode fast = head; 
		
		// Find meeting point
		while (fast != null && fast.next != null) { 
			slow = slow.next; 
			fast = fast.next.next;
			if (slow == fast) {
				break;
			}
		}

		// Error check - there is no meeting point, and therefore no loop
		if (fast == null || fast.next == null) {
			return null;
		}

		/* Move slow to Head. Keep fast at Meeting Point. Each are k steps
		/* from the Loop Start. If they move at the same pace, they must
		 * meet at Loop Start. */
		slow = head; 
		while (slow != fast) { 
			slow = slow.next; 
			fast = fast.next; 
		}
		
		// Both now point to the start of the loop.
		return fast;
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
	
	/**
	 * Create Circle Linked List (array)
	 * Time: O(n) Space: O(n)
	 * @param arr
	 * @return
	 */
	public static LinkedListNode createCircleLinkedList(int node_num, int k) {
		
		LinkedListNode head = null, curr = null, rev_k_node = null;
		for (int i = 0; i < node_num; i++) {
			LinkedListNode node = new LinkedListNode(i+1);
			if (i == 0) {
				head = node;
				curr = head;
			} else {
				curr.next = node;
				curr = curr.next;
			}
			if (i == node_num - k)
				rev_k_node = node;
		}
		curr.next = rev_k_node;
		return head;
	}
	
	/**
	 * Create Circle Linked List (array)
	 * Time: O(n) Space: O(n)
	 * @param arr
	 * @return
	 */
	public static LinkedListNode[] createArrayCircleLinkedList(int node_num, int k) {
		
		// Create linked list
		LinkedListNode[] nodes = new LinkedListNode[node_num];
		for (int i = 0; i < node_num; i++) {
			nodes[i] = new LinkedListNode(i + 1);
			if (i > 0)
				nodes[i-1].next = nodes[i];
		}
				
		// Create loop;
		if (k > 0 && k < node_num)
			nodes[node_num - 1].next = nodes[node_num - k];
		
		return nodes;
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases
		 */
		int node_num = 100;
		int k = 10;
		
		LinkedListNode loop1_head1 = createCircleLinkedList(node_num, k);
		LinkedListNode[] loop2 = createArrayCircleLinkedList(node_num, k);
		
		LinkedListNode loop = findLoopBeginning(loop2[0]);
		if (loop == null) {
			System.out.println("No cycle.");
		} else {
			System.out.println(loop.val);
		}
	}
}
