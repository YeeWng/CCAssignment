package ch3;

/**
 * Fixed stack solution to simulate three stacks in an array.
 * Time: 
 * 		pop:O(1)
 * 		push:O(1)
 * 		top:O(1)
 * 		empty:O(1)
 * 		print:O(n)
 * Space:
 * 		O(n)
 * 
 * @author Name: YiWang 
 * 		   Andrew ID: wydaniel
 *
 */
public class Solution31 {
	
	private int stackSize = 100;
	private int stackNum = 3;
	private int[] buffer = new int [stackSize * stackNum];
	private int[] stackIndex = {-1, -1, -1};
	
	public void push(int stackNum, int value) throws Exception{
		if (stackIndex[stackNum] + 1 >= stackSize) {
			throw new Exception("Stack " + stackNum + " is out of space.\n");
		}
		stackIndex[stackNum]++;
		buffer[getIndexOfBuffer(stackNum)] = value;
	}
	
	public int pop(int stackNum) throws Exception{
		if (stackIndex[stackNum] == -1) {
			throw new Exception("Stack " + stackNum + " is empty.");
		}
		int value = buffer[getIndexOfBuffer(stackNum)];
//		buffer[getIndexOfBuffer(stackNum)] = 0;
		stackIndex[stackNum]--;
		return value;
	}
	
	public int top(int stackNum) {
		int index = getIndexOfBuffer(stackNum);
		return buffer[index];
	}
	
	public boolean isEmpty(int stackNum) {
		return stackIndex[stackNum] == -1;
	}
	
	private int getIndexOfBuffer(int stackNum) {
		return stackNum * stackSize + stackIndex[stackNum];
	}
	
	public void printInfo(int stackNum) {
		if(isEmpty(stackNum)) 
			System.out.println("The stack is empty!");
		
		try {
		while(!isEmpty(stackNum)) {
			if(stackIndex[stackNum] != 0) {
				System.out.print(top(stackNum) + "-->");
			}else{
				System.out.println(top(stackNum));
			}
			pop(stackNum);
		}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Testing cases
	 * @param args
	 */
	public static void main(String[] args) {
		Solution31 fixedStack = new Solution31();
		try{
			fixedStack.push(0, 1);
			fixedStack.push(0, 2);
			fixedStack.push(0, 3);
			fixedStack.push(0, 4);
			fixedStack.push(1, 5);
			fixedStack.push(1, 6);
			fixedStack.push(1, 7);
			fixedStack.push(1, 8);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		fixedStack.printInfo(0);
		fixedStack.printInfo(1);
		fixedStack.printInfo(2);
	}

}
