package ch2;

import ch2.LinkedListNode;

public class Solution27 {
	
	/**
	 * Algorithm: We can simply get a conclusion: when the two linked lists
	 * 		do not have the same tail reference they will not intersect with
	 * 		each other. So our algorithm is based on this idea: to align the 
	 * 		tail of two lists and then find the same reference as intersection
	 * Time Complexity: O(n)	Space Complexity: O(1)
	 * @param h1
	 * @param h2
	 * @return
	 */
	public static LinkedListNode findIntersection(LinkedListNode h1, LinkedListNode h2) {
		// edge case
		if (h1 == null || h2 == null) return null;
		
		LinkedListTail t1 = getTail(h1);
		LinkedListTail t2 = getTail(h2);
		
		// base idea: when two lists do not have the same reference on tail
		// they will not intersect with each other
		if (t1.tail != t2.tail) return null;
		
		LinkedListNode shrter = t1.size < t2.size ? h1 : h2;
		LinkedListNode longer = t1.size < t2.size ? h2 : h1;
		
		// Find the start node on longer lists to align the two lists 
		for (int k = Math.abs(t1.size - t2.size); k > 0 && longer != null; k--) {
			longer = longer.next;
		}
		
		// After align, we can check the reference collision.
		while (shrter != longer) {
			shrter = shrter.next;
			longer = longer.next;
		}
		
		return longer; 	
	}
	
	/**
	 * Inner class to save the Tail info.
	 * @author Matrix
	 *
	 */
	public static class LinkedListTail {
		LinkedListNode tail;
		Integer size;
		public LinkedListTail(LinkedListNode tail, int size) {
			this.tail = tail;
			this.size = Integer.valueOf(size);
		}
	}

	/**
	 * Get linked list tail node and linked list length
	 * @param h
	 * @return
	 */
	public static LinkedListTail getTail(LinkedListNode h) {
		if(h == null) return null;
		
		int size = 1;
		LinkedListNode curr = h;
		while (curr.next != null){
			size++;
			curr = curr.next;
		}
		return new LinkedListTail(curr, size);
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
		 * Testing cases:
		 */
		int[] vals1 = {-1, -2, 0, 1, 2, 3, 4, 5, 6, 7, 8};
		int[] vals2 = {12, 14, 15};
		LinkedListNode list1 = createLinkedList(vals1);
		LinkedListNode list2 = createLinkedList(vals2);
		
		// merge two lists to form the same reference node
		list2.next.next = list1.next.next.next.next.next;
		
		System.out.println("Original List: ");
		printLinkedList(list1);
		printLinkedList(list2);

		System.out.println("Result List: ");
		LinkedListNode ret_intersec = findIntersection(list1, list2);
		System.out.println("The intersection node value is: "+ ret_intersec.val);
	}
}
