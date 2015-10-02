package ch10;

public class Solution103 {

	/**
	 * Binary search in a rotated order array
	 * Time: O(lon N) N is the number of data
	 * Space: O(1)
	 * 
	 * @param a
	 * @param x
	 * @return
	 */
	public static int binarySearch(int[] a, int x) {
		
		int low = 0, high = a.length;
		while (low < high) {
			// implementation problem: bit shift priority is the lowest
			int mid = low + ((high - low)>>1);
			
			if (x == a[mid]) return mid;
			if (a[low] <= a[mid]) {
				if (a[low] <= x && x < a[mid])
					high = mid;
				else
					low = mid + 1;
			} else {
				if (a[mid] < x && x <= a[high-1])
					low = mid + 1;
				else
					high = mid;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] cas1 = {15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14};
		for (int i : cas1) {
			System.out.println(i + ":" + binarySearch(cas1, i));
		}
	}

}
