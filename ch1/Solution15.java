package ch1;

public class Solution15 {

	/**
	 * One Edit distance
	 * Algorithm: basic idea is discussed 3 conditions 
	 * 		when the difference length of string1 and string2
	 * 		is belongs to [-1, 0, 1]
	 * Time: O(n)	Space: O(1) 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isOneEditDistance(String s1, String s2) {
		if (s1.length() - s2.length() > 1 ||
				s2.length() - s1.length() > 1) {
			return false;
			
		}
		
		int diff = 0;
		int i = 0, j = 0;
		while (i < s1.length() && j < s2.length()) {
			if (s1.charAt(i) != s2.charAt(j)) {
				diff++;
				if (s1.length() > s2.length())
					i++;
				if (s1.length() < s2.length())
					j++;
				if (s1.length() == s2.length()) {
					i++; j++;
				}
			} else {
				i++; j++;
			}
			if (diff > 1) return false;
		}
		
		if (diff == 1 && s1.length()!=s2.length() && 
				(i!=s1.length() || j!=s2.length()))
			return false;
		return true;
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases.
		 */
		String[][] pairs = {{"ple", "pale"}, {"", "t"}, {"a", ""}, 
							{" ", " "}, {"", ""}, {"", " "}, {"pales", "pale"},
							{"pale", "bale"}, {"pale", "bake"}};
		for (String[] pair : pairs) {
			String a = pair[0];
			String b = pair[1];
			boolean isOneEditAway = isOneEditDistance(a, b);
			System.out.println(a + ", " + b + ": " + isOneEditAway);
		}
		
	}

}
