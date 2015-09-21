package ch1;

public class Solution13 {
	
	/**
	 * Time complexity: O(n)	Space complexity: O(1)
	 * @param str
	 * @param length
	 */
	public static void replaceSpaces(char[] str, int length) {
		int spaces = 0;
		for (int i = 0; i < length; i++) {
			if (str[i] == ' ') spaces++;
		}
		
		int j = length + spaces * 2;
		str[j] = '\0';
		for (int i = length - 1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[--j] = '0';
				str[--j] = '2';
				str[--j] = '%';
			} else {
				str[--j] = str[i];
			}
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases.
		 */
		// Construct the data structure. 
		String str = " ";//"abc d e   fghijk"
		int spaces = 0;
		for (int i = 0; i<str.length(); i++)
			if (str.charAt(i) == ' ') spaces++;
		
		char[] arr = new char[str.length() + spaces * 2 + 1];
		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}
		for (int i = str.length(); i < arr.length; i++) {
			arr[i] = ' ';
		}
		
		replaceSpaces(arr, str.length());
		
		String s = new String(arr);
		System.out.println("\"" + s + "\"");
	}
}
