package ch3;

public class Solution32 {

	/**
	 * Min Stack: maintain another array to get the min value.
	 * 
	 * Push: Each time to push a new value, I will check the min
	 * 			stack to see whether it is smaller than current min.
	 * 			Then, push the smaller value to min stack.
	 * Pop: Each time to pop a value, I will check whether it's equal
	 * 			to current min value. If it is the current min, remove 
	 * 			the min value from min stack in the same time.
	 * 
	 * Time Complexity: the same as usual stack.
	 * Space Complexity: the same as usual stack.
	 * 
	 * @param args
	 */
	
	final int stackSize = 10000;
	int[] stk = new int[stackSize];
	int idxStk = 0;
	int min = Integer.MAX_VALUE;
	int[] minStk = new int[stackSize];
	int idxMinStk = 0;
	
	public void push(int x) {
		stk[idxStk++] = x;
		if (min >= x) {
			min = x;
			minStk[idxMinStk++] = min;
		}
	}
	
	public int pop() {
		if (idxStk == 0) return Integer.MAX_VALUE;
		if (stk[idxStk - 1] == min) {
			idxMinStk--;
			min = idxMinStk!=0 ? minStk[idxMinStk-1] : Integer.MAX_VALUE;
		}
		return stk[--idxStk];
	}
	
	public int top() {
		return stk[idxStk - 1];
	}
	
	public int getMin() {
		return min;
	}
	
	public boolean isEmpty() {
		return idxStk == 0;
	}
	
	public void printStackInfo() {
		if(isEmpty()) 
			System.out.println("The stack is empty!");
		
		while(!isEmpty()) {
			if(idxStk != 1) {
				System.out.print(top() + "-->");
			}else{
				System.out.println(top());
			}
			pop();
		}
	}
	
	public void printMinStackInfo() {
		if(idxMinStk == 0) 
			System.out.println("The min stack is empty!");
		
		while(idxMinStk != 0) {
			if(idxMinStk != 1) {
				System.out.print(minStk[idxMinStk-1] + "-->");
			}else{
				System.out.println(minStk[idxMinStk-1]);
			}
			pop();
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Min stack testing.
		 */
		Solution32 minStack = new Solution32();
		try{
			minStack.push(6);
			minStack.push(5);
			minStack.push(4);
			minStack.push(3);
			minStack.push(2);
			System.out.println("Stack min value = " + minStack.getMin());
			minStack.push(1);
			minStack.push(7);
			System.out.println("Stack min value = " + minStack.getMin());
			minStack.push(8);
			System.out.println("Stack min value = " + minStack.getMin());
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		minStack.printStackInfo();
		minStack.printMinStackInfo();
	}
}
