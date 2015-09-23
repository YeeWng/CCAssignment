package ch3;

import java.util.Stack;

public class Solution35 {

	/**
	 * Sorting with additional stack
	 * Time Complexity:
	 * 		O(n^2) n is the original stack element number
	 * Space Complexity:
	 * 		O(n)
	 * @param s
	 * @return
	 */
	public static Stack<Integer> sort(Stack<Integer> s) {
		Stack<Integer> r = new Stack<Integer>();
		
		while (!s.empty()) {
			Integer tmp = s.pop();
			while (!r.isEmpty() && r.peek() > tmp) {
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		
		int[] cas1 = {8, 1, 5, 4, 3, 6};
		for (int i : cas1) 
			s.push(i);
		Stack<Integer> r = sort(s);
		for (int i = 0; i < cas1.length; i++) {
			if (i != cas1.length - 1)
				System.out.print(r.pop() + " -> ");
			else
				System.out.println(r.pop());
		}
	}

}
