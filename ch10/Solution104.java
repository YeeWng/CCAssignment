package ch10;

import java.util.Vector;

public class Solution104 {

	/**
	 * Find the element index in a data structure without size() method.
	 * Algorithm: double the index and try to find the element position then
	 * 				conduct binary search.
	 * Time: O(log(n)) n is the number of data
	 * Space: O(1)
	 * 
	 * Just to show the algorithm using the Vector. However, the method
	 * elementAt for Vector can not return -1 when Vector do not contain 
	 * the element. Vector just throws an Exception. So to simulate the
	 * element I just set x to -1. 
	 * 
	 * @param list
	 * @param x
	 * @return
	 */
	public static int sortedSearch(Vector<Integer> list, int x) {
		int idx = 1;
		try {
			while (list.elementAt(idx) >= 0 && list.elementAt(idx) < x) {
				idx *= 2;
			}
		} catch(Exception e) {
//			System.out.println(idx/2 + " ~ " + idx);
			return sortedSearch(list, x, idx / 2, idx);
		}
		return sortedSearch(list, x, idx / 2, idx);
	}
	
	public static int sortedSearch(Vector<Integer> list, int target, int low, int high) {
		int mid;
		while (low <= high) {
			mid = low + ((high - low)>>1);
			int x;
			if (mid >= list.size())
				x = -1;
			else
				x = list.elementAt(mid);
//			int x = list.elementAt(mid);
			if (x > target || x < 0)
				high = mid - 1;
			else if (x < target)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] cas1 = {1, 3, 4, 5, 7, 10, 14, 15, 16, 19, 20, 25};
		Vector<Integer> vec = new Vector<Integer>();
		for (int i : cas1) 
			vec.add(i);
		System.out.println(vec);
		for (int i : cas1)
			System.out.println(i + ":" + sortedSearch(vec, i));
	}
}
