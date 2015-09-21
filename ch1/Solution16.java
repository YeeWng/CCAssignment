package ch1;

public class Solution16 {

	/**
	 * Algorithm: simulation
	 * Time: O(n)	Space: O(1)
	 * @param s
	 * @return
	 */
	public static String stringCompression(String s) {
		StringBuilder ret = new StringBuilder();
		int counter = 0;
		for (int i = 0; i < s.length(); i++) {
			counter++;
			
			if (i + 1 >= s.length() || s.charAt(i)!=s.charAt(i+1)) {
				ret.append(s.charAt(i));
				ret.append(counter);
				counter = 0;
			}
		}
		return ret.length() <= s.length() ? ret.toString() : s;
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases.
		 */
		String[] str = {"aa", "aaaaabbbbaaaabbddc", "  ", " "};
		for (String s : str) {
			System.out.println("Original: " + s);
			System.out.println("Result:" + stringCompression(s));
		}
	}

}
