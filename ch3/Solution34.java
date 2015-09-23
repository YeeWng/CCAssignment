package ch3;

import java.util.Stack;

public class Solution34 {
	
	/**
	 * Two stacks simulate Queue (Very interesting)
	 * Time Complexity:
	 * 		Peek:	The worst case is O(n)
	 * 				However the average case is theta(1)
	 * 		Remove: The same as Peek.
	 * 				The worst case is O(n)
	 * 				However the average case is theta(1)
	 * 		isEmpty: O(1)
	 * 		size:	O(1)
	 * 
	 *		So this queue is not so bad because many operations average time
	 *			complexity is equal to the normal queue.
	 * Space Complexity: O(n)
	 * @author Matrix
	 *
	 * @param <T>
	 */
	public static class MyQueue<T> {
		public Stack<T> stkNew = new Stack<T>();
		public Stack<T> stkOld = new Stack<T>();
		
		public void add(T item) {
			stkNew.push(item);
		}
		
		public T peek() {
			shiftStacks();
			return stkOld.peek();
		}
		
		public T remove() {
			shiftStacks();
			return stkOld.pop();
		}
		
		public boolean isEmpty() {
			return stkNew.isEmpty() && stkOld.isEmpty();
		}
		
		private void shiftStacks() {
			if (stkOld.isEmpty()) {
//				System.out.println(stkNew.size() + " " + stkOld.size());
				
				while (!stkNew.isEmpty()) {
					stkOld.push(stkNew.pop());
				}
			}
		}
		
		public int size() {
			return stkNew.size() + stkOld.size();
		}
		
		public void print() {
			while (!isEmpty()) {
				if (size() > 1)
					System.out.print(remove() + " -> ");
				else
					System.out.println(remove());
			}
		}
	}

	public static void main(String[] args) {
		MyQueue<Integer> queue = new MyQueue<Integer>();
		
		/**
		 * Testing case
		 */
		for (int i = 0; i<5; i++)
			queue.add(i+8);
		
		//Before test
		System.out.println("Before: ");
//		queue.print();
//		System.out.println(queue.stkNew.size() + " " + queue.stkOld.size());
		
		System.out.println(queue.peek());
		queue.remove();
		queue.remove();
		System.out.println("After 2 removing steps from queue:");
		queue.print();
	}

}
