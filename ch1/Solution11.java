package ch1;

public class Solution11 {

	/**
	 *  Time complexity: O(n)	Space complexity: O(1)
	 * @param s
	 * @return
	 */
	public static boolean isUniqueChars(String s) {
		// Assumption: the character set is ASCII
		// ASCII character set size is 256
		
		if (s.length() > 256) return false;
		
		boolean[] hash = new boolean[256];
		for (int i=0; i<s.length(); i++) {
			int v = s.charAt(i);
			if (hash[v]) {
				return false;
			}
			hash[v] = true;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		/**
		 *  There are some edge cases.
		 */
		String[] words = {"abcde", "hello", "apple", "kite", "padle", 
						 	"a  bc", "a\tbc", "a\r\nbc"};
		int i = 0;
		for (String word : words) {
			System.out.println(++i + "#:" + word + ": " + isUniqueChars(word));
		}
	}

}
