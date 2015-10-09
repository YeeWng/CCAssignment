package ch5;

public class Solution506 {

	/**
	 * Ch5 Question 6: Conversion
	 * 
	 * Algorithm: Take advantage of the logistic function XOR, same value is 0, diff is 1
	 * Time: O(m) m is the bits number in an integer
	 * Space: O(1) 
	 * 
	 * @param a integer a
	 * @param b integer b
	 * @return number of flip from a to b
	 */
	public static int bitSwap(int a, int b) {
		int cnt = 0, c = a ^ b;
		if (c < 0) {
			cnt++;
			c ^= Integer.MIN_VALUE;
		}
		for (; c!=0; c = c & (c-1)) {
			cnt ++;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		int a = 2, b = 8;
		System.out.println("Bits to flip :" + bitSwap(a, b));
	}

}
