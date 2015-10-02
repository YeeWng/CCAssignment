package ch10;

public class Solution1011 {

	/**
	 * Solution for Peaks and Valleys.
	 * Algorithm:
	 * 		Scan two times. First time, just scan odd position in array and 
	 * 		make descend between current position and its next position
	 * 		Second time, scan even position in array and make ascend between
	 * 		current position and its next position.
	 * 
	 * 		I can prove this solution is right. Because when we scan odd 
	 * 		position we will make a descend order for odd position number
	 * 		and its right number. When we scan even position number we are
	 * 		making a ascend order, which means we just need to consider the
	 * 		smaller one and will not break last time scanning result. 
	 * 		
	 * Time Complexity: O(n)
	 * Space Complexity: O(1)
	 * 
	 * @param a Input data
	 */
	public static void getPeaksAndValleys(int[] a) {
		if (a == null || a.length <= 1)
			return;
		for (int i = 0; i < a.length - 1; i += 2) {
			if (a[i] < a[i+1]) {
				int t = a[i];
				a[i] = a[i+1];
				a[i+1] = t;
			}
		}
		for (int i = 1; i < a.length - 1; i += 2) {
			if (a[i] > a[i+1]) {
				int t = a[i];
				a[i] = a[i+1];
				a[i+1] = t;
			}
		}
	}
	
	
	public static void main(String[] args) {
		int[] cas1 = {5, 3, 1, 2, 3};
		getPeaksAndValleys(cas1);
		for (int i : cas1)
			System.out.print(i + " ");
		System.out.println();
	}

}
