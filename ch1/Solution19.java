package ch1;

public class Solution19 {

	/**
	 * Core algorithm time complexity. If based on KMP, it is O(n).
	 * @param s
	 * @param t
	 * @return
	 */
	public static boolean isSubstring(String s, String t) {
		
		return s.indexOf(t) >= 0;
	}
	
	/**
	 * Algorithm: Simulation. Basic idea: explore patterns
	 * Time: O(n)	Space: O(n)
	 * The time complexity is based on the substring time complexity.
	 * @param s1
	 * @param s2
	 * @return
	 */
	public static boolean isRotation(String s1, String s2) {
	    // check s1 and s2 are equal length and not empty
	    if (s1.length() == s2.length() && s1.length() > 0) {
	    	String s1s1 = s1 + s1;
	    	return isSubstring(s1s1, s2);
	    }
	    return false;
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases.
		 */
		String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
		for (String[] pair : pairs) {
			String s1 = pair[0];
			String s2 = pair[1];
			boolean is_rotation = isRotation(s1, s2);
			System.out.println(s1 + ", " + s2 + ": " + is_rotation);
		}
	}
}
