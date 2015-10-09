package ch5;

public class Solution507 {

	/**
	 * Ch5 Question 7: Pairwise Swap.
	 * 
	 * Algorithm: Logistic function & usage: 
	 * 				& 0xaaaaaaaa -> get even 
	 * 				& 0x55555555 -> get odd
	 * 				then shift to get answer
	 * Time:
	 * Space: 
	 * 
	 * @param x
	 * @return
	 */
    public static int swapEvenOdd(int x) {
    	return ((x & 0xaaaaaaaa) >> 1) | ((x & 0x55555555) << 1);
    }
    
    public static void main(String[] args) {
		int cas = 8;
		System.out.println("Pairwise swap even and odd bits : " + swapEvenOdd(cas));
	}

}
