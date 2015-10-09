package ch5;

public class Solution505 {

	/**
	 * 
	 * 	Answer: 
	 *  n & (n - 1) == 0 means that n & (n - 1) do not share any common 1s
	 *  When subtract 1 from a number, actually the k bits (k+1 is 1, 0~k are 0) in n will be flip of each other. So that means from k position to 0 position are all zeros, because in that case, the following of (n - 1) could be all ones.
	 *  
	 *  For example: 1000-1 => 0111  1000 & 0111 = 0, which is 0 
	 *  			 1111-1 => 1110  1111 & 1110 = 1110, which is not 0
	 *  
	 *  So, the n & (n -1) == 0 checks if n is a power of 2 (when n!=0).
	 *  
	 */

		  
}
