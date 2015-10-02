package ch10;

public class Solution101 {

	/**
	 * Merge two sorted array together 
	 * Algorithm: 
	 * 		firstly, judge whether two arrays are the same ascend
	 * 		secondly, merge
	 * Time Complexity: O(n) n is the number of two arrays.
	 * 
	 * @param a		Array a
	 * @param b		Array b
	 * @param alen	Array length a
	 * @param blen	Array length b
	 */
	public static void sortedMerge(int[] a, int[] b, int alen, int blen) {
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
		
		if (a == null || b == null ||
				alen == 0 || blen == 0)
			return;
		boolean aIsAscend = checkAscend(a, alen);
		boolean bIsAscend = checkAscend(b, blen);
		if (aIsAscend ^ bIsAscend == true) {
			if (aIsAscend)
				reverse(b, blen);
			else
				reverse(a, alen);
		}
		int len = alen + blen - 1;
		for (int p = alen - 1, q = blen - 1, k = len; q >= 0;) {
			if (p >= 0 && a[p] > b[q]) {
				a[k] = a[p];
				p--;
			} else {
				a[k] = b[q];
				q--;
			}
			k--;
		}
	}
	
	public static boolean checkAscend(int[] arr, int len) {
		if (len == 1) return true;
		return arr[0] < arr[len - 1];
	}
	
	public static void reverse(int[] arr, int len) {
		for (int i = 0, j = len - 1; i < j; i++, j--) {
			int t = arr[i];
			arr[i] = arr[j];
			arr[j] = t;
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases
		 */
		int[] cas1 = {15, 10, 5};
		int[] cas2 = {1, 2, 3, 6, 8};
		int[] a = new int[3+5];
		for (int i = 0; i < cas1.length; i++) {
			a[i] = cas1[i]; 
		}
		sortedMerge(a, cas2, 3, 5);
		
		for (int i : a)
			System.out.print(i + " ");
		System.out.println();
		
	}

}
