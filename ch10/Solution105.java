package ch10;

public class Solution105 {
	
	/**
	 * Binary Search in string array with empty strings("")
	 * 
	 * Time Complexity: O(n) the worst case will become to linear search.
	 * Space Complexity: O(1) 
	 * 
	 * 
	 * @param strs
	 * @param str
	 * @return
	 */
	public static int search(String[] strs, String str) {
		if (strs == null || str == null || str == "")
			return -1;
		int low = 0, high = strs.length - 1;
		while (low <= high) {
			int mid = low + ( (high - low)>>1 );
			if (strs[mid].isEmpty()) {
				int left = mid - 1;
				int right = mid + 1;
				while (true) {
					if (left < low && right > high)
						return -1;
					else if (right <= high && !strs[right].isEmpty()) {
						mid = right;
						break;
					} else if (left >= low && !strs[left].isEmpty()) {
						mid = left;
						break;
					}
					right++;
					left--;
				}
			}
			if (str.equals(strs[mid]))
				return mid;
			else if (strs[mid].compareTo(str) < 0)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		/**
		 * Test case
		 */
		String[] cas1 = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
		for (String s : cas1) {
			System.out.println(s + ":" + search(cas1, s));
		}
	}

}
