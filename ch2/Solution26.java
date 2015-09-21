package ch2;

import ch2.LinkedListNode;

public class Solution26 {

	/**
	 * Method: Runner techniques
	 * Time Complexity: O(n)	Space Complexity: O(1)
	 * @param head linkedlist head
	 * @return 
	 */
	public static boolean isPalindrome(LinkedListNode head) {
		// edge case 1: 
		if (head == null || head.next == null) return false;
		
		// initial slow and fast pointer
		LinkedListNode slow = head;
		LinkedListNode fast = head;
		
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		LinkedListNode tail = reverseLinkedList(slow.next);
		LinkedListNode p = head, q = tail;
		while (q != null) {
			if (p.val != q.val)
				return false;
			else {
				p = p.next;
				q = q.next;
			}
		}
		return true;
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
		 * Testing cases
		 */
		int[] vals1 = {2, 4, 1, 4, 2};
		int[] vals2 = {2, 4, 1, 5, 2};
		LinkedListNode list1 = createLinkedList(vals1);
		LinkedListNode list2 = createLinkedList(vals2);
		
		System.out.println("Original List: ");
		printLinkedList(list1);
		printLinkedList(list2);
				 
		System.out.println("Result List: ");
		boolean r1 = isPalindrome(list1);
		boolean r2 = isPalindrome(list2);
		System.out.println(r1);
		System.out.println(r2);
	}

}
