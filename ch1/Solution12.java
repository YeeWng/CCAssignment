package ch1;

public class Solution12 {
	
	/**
	 *  Time complexity: O(n)	Space complexity: O(1)
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean permutation(String s, String t) {
		
		if (s.length() != t.length()) {
			return false;
		}
		
		// Assumption: char set is ASCII
		// ASCII character set size is 256
		int[] hash = new int[256];
		
		// count number of each char in s.
		for (int i = 0; i < s.length(); i++) {
			int c = (int) s.charAt(i);
			hash[c]++;  
		}
		  
		for (int i = 0; i < t.length(); i++) {
			int c = (int) t.charAt(i);
			hash[c]--;
		    if (hash[c] < 0) {
		    	return false;
		    }
		}
		  
		return true;
	}
	
	public static void main(String[] args) {
		/**
		 *  There are some edge cases
		 */
		String[][] pairs = {{"apple", "paepl"}, {"carrot", "tarroc"}, {"hello", "llloh"}, 
							{" ", " "}, {"", ""}, {"", " "}, {"a  p", "ap  "}};
		for (String[] pair : pairs) {
			String word1 = pair[0];
			String word2 = pair[1];
			boolean anagram = permutation(word1, word2);
			System.out.println(word1 + ", " + word2 + ": " + anagram);
		}
	}

}
