package ch10;

import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution102 {

	/**
	 * Group anagrams
	 * 
	 * Hash + sort string
	 * 
	 * Time Complexity: 
	 * 	Depends on HashMap complexity. 
	 * 		If HashMap is implemented by BST. The time complexity is:
	 * 		O(n*log(n)*m*log(m)) 
	 * 			n is the string number and m is the average string length
	 * 		If HashMap is implemented by hash table. The time complexity is:
	 * 		O(n*m*log(m))
	 * 			n and m is the same meaning with previous definition.
	 * 
	 * Space Complexity: O(n) n is the strings' number
	 * 
	 * @param arr
	 */
	public static void groupAnagrams(String[] arr) {
		HashMap<String, ArrayList<String>> hash = new HashMap<String, ArrayList<String>>();
		
		for (String s : arr) {
			String key = sortString(s);
			ArrayList<String> list = hash.get(key);
			if (list == null)
				list = new ArrayList<String>();
			list.add(s);
			System.out.println(key + " " + list);
			hash.put(key, list);
		}
		
		int idx = 0;
		for (String key : hash.keySet()) {
			ArrayList<String> list = hash.get(key);
			for (String s : list) {
				arr[idx++] = s;
			}
		}
	}
	
	public static String sortString(String s) {
		char[] c = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
	}
	
	public static void main(String[] args) {
		String[] cas1 = {"acre", "ac", "race", "care", "arec", "bd"};
//		for (String s : cas1) {
//			System.out.println(s);
//		}
		System.out.println("Process:");
		groupAnagrams(cas1);
		System.out.println("\n\nResult:");
		for (String s : cas1) {
			System.out.println(s);
		}
	}

}
