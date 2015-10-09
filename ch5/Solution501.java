package ch5;

public class Solution501 {

	/**
	 * Ch5 Question 1: Insertion
	 * 
	 * Method: bit manipulation
	 * Time: O(1)
	 * Space: O(1)
	 * 
	 * @param n number of been inserted
	 * @param m number of insertion
	 * @param i insertion start position
	 * @param j insertion end position
	 * @return bit insertion result
	 */
	public static int insertBits(int n, int m, int i, int j) {
		int ret = ~0;	// all 1 bit
		int mask = (ret << (j + 1)) | ( (1 << i)  - 1); // make mask
		
		int n_clear = n & mask;	//prepare n: clear n
		int m_clear = m << i;	//prepare m: shift m
		return n_clear | m_clear;	//result
	}
	
	public static void main(String[] args) {
		int n = 1 << 10, m = 19, i = 3, j = 7;
		int ret = insertBits(n, m, i, j);
		System.out.print("Before: " + Integer.toBinaryString(n) + "\t");
		System.out.println(Integer.toBinaryString(m));
		System.out.println("After : " + Integer.toBinaryString(ret));
	}

}
