package ch3;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * This question is very useful. It simulated the real stack data structure
 * implementation.
 * Time complexity: as usual Stack
 * Space complexity: as usual Stack
 * 
 * Follow up question:
 * popAt(idx) : First determine the empty stacks in the stack list. Then, 
 * 				remove the empty stack. And then we can pop from the stack 
 * 				list at position idx.
 * 
 * 				Time: O(n) n is the number of 
 * 				stacks in the stack list.
 * 
 * pop() : 		Time: O(1);
 * 
 * @author Matrix
 *
 */
public class Solution33 {
	
	public static int capacityEachStack = 3;
	
	/**
	 * Fixed capacity stack simulated by array
	 * This problem must use the fixed capacity stack
	 * 
	 * @author Matrix
	 *
	 */
	public class Stack {
		private int capacity;
		private int size = 0;
		private int[] s;
		
		public Stack(int capacity) { 
			this.capacity = capacity; 
			s = new int[capacity];
		}
		
		public boolean isEmpty() {
			return size == 0;
		}
		
		public boolean isFull() { 
			return capacity == size; 
		}
		
		public int top() throws Exception {
			if (isEmpty())
				throw new Exception("Stack is empty. No top.");
			return s[size - 1];
		}
		
		public boolean push(int v) {
			if (size >= capacity) return false;
			s[size++] = v;
			
			return true;
		}
		
		public int pop() throws EmptyStackException{
			if (isEmpty()) {
				throw new EmptyStackException();
			}
			return s[--size];
		}
	}
	
	/**
	 * Question required structure
	 */
	ArrayList<Stack> stack_list = new ArrayList<Stack>();
	
	public void push(int v) {
		Stack last = topStack();
		if (last != null && !last.isFull()) {
			last.push(v);
		} else {
			Stack s = new Stack(capacityEachStack);
			s.push(v);
			stack_list.add(s);
		}
	}
	
	public Stack topStack() {
		if (stack_list.size() == 0)
			return null;
		return stack_list.get(stack_list.size() - 1);
	}
	
	public int pop() throws Exception {
		if (isEmpty())
			throw new EmptyStackException();
		Stack last = topStack();
		int v = last.pop();
		if (last.isEmpty())
			stack_list.remove(stack_list.size() - 1);
		return v;
	}
	
	public int top() throws Exception {
		Stack last = topStack();
		int v = last.top();
		if (last.isEmpty())
			stack_list.remove(stack_list.size() - 1);
		return v;
	}
	
	public boolean isEmpty() {
		Stack last = topStack();
		return last == null || last.isEmpty();
	}
	
	public int popAt(int idx) throws Exception {
		if (isEmpty())
			throw new EmptyStackException();
		int sz = stack_list.size();
		for (int i = 0; i < sz; i++) {
			Stack s = stack_list.get(i);
			if (s.isEmpty())
				stack_list.remove(i);
		}
		if (idx >= sz)
			throw new Exception("Index out of stack list.");
		Stack stk = stack_list.get(idx);
		int v = stk.pop();
		if (stk.isEmpty())
			stack_list.remove(idx - 1);
		return v;
	}
	
	/**
	 * Testing the huge stack made from fixed capacity stacks
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// Stack parameter setting
		int capacity_per_substack = 3; //capacity is 3 means the fixed stack is 5
		Solution33.capacityEachStack = capacity_per_substack;
		
		Solution33 stack = new Solution33();
		stack.push(2);	// stack 1
		stack.push(1);
		stack.push(4);
		stack.push(3);	// stack 2
		stack.push(5);
		stack.push(8);
		stack.push(9);	// stack 3
		stack.push(10);
		
		System.out.println(stack.pop()); 
		System.out.println("Follow UP: popAt");
		System.out.println(stack.popAt(0));
		System.out.println(stack.popAt(2));
	}

}
