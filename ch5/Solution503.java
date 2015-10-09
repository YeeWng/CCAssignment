package ch5;

import java.util.ArrayList;
import java.util.List;

public class Solution503 {

	/**
	 * Ch5 Question 3: flip bit to win
	 * Algorithm: first make one pass to obtain the number of continuous 0 or 1's
	 * 			  second merge them 
	 * Time: O(n) 	n is the bits number
	 * Space: O(n)
	 * 
	 */
	
	static int SEQ_LENGTH = 32;

	// Select the longest 
	public static int longestSeq(int n) {
		
		// edge case
		if(n == -1) return SEQ_LENGTH;
		
		List<Integer> seqList = getContinousStatistics(n);
//		System.out.println(seqList);
		return findLongestSeq(seqList);
	}
		
	public static List<Integer> getContinousStatistics(int n) {
		
		List<Integer> list = new ArrayList<Integer>();
		
		int last_digit = 0; // here make sure the first seq is zero seq
		int counter = 0;
		for (int i = 0; i < SEQ_LENGTH; i++) {
			if ( (n & 1) != last_digit ) {  	// get the bit value of last digit
				list.add(counter);
				last_digit = n & 1; 			// keep last digit
				counter = 0;
			}
			counter++; 
			n >>>= 1;
		}
		list.add(counter);
		return list;
	}
		
	public static int findLongestSeq(List<Integer> seqList){
		int maxSeq = 1;
		
		for (int i = 0; i < seqList.size(); i += 2) {
			int zeroSeq = seqList.get(i);	// when i = 0, the first seq must be zero seq
			int right = i-1 >= 0 ? seqList.get(i - 1) : 0;
			int left = i+1 < seqList.size() ? seqList.get(i + 1) : 0;
			
			int cur  = 0;
			if (zeroSeq == 1) { 		// merge one zero interval
				cur = left + right + 1;
			} else if (zeroSeq > 1) { 	// one more zero interval, select right or left
				cur = 1 + Math.max(left, right);
			} else if (zeroSeq == 0) { 	// no zero interval, either side 
				cur = Math.max(left, right); 
			}
	 
			maxSeq = Math.max(cur, maxSeq); //select the maximum
		}
		return maxSeq;
	}
	
	public static void main(String[] args) {
		int cas1 = 1775;
		System.out.println(Integer.toBinaryString(cas1));
		System.out.println(longestSeq(cas1));
	}
}
