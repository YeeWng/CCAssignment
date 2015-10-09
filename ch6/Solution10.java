package ch6;

public class Solution10 {

	/**
	 * Ch6 Question 10: Find posion bottle: 
	 * 
	 * We can take the 10 strips as the binary presentation of bottles. 
	 * Assume bottle number is from 1 to 1000. 
	 * 
	 * The #1 bottle pull on the first strip.  (01)
	 * The #2 bottle pull on the second strip.  (10)
	 * Teh #3 bottle pull on the first and second  strip. (11)
	 * ...
	 * 
	 * The after seven days, we know which of the bottle is poison. Just use the presentation by binary strips. If #1, #2, #4 strips are positive, then the 1011 -> #13 bottle is poison.
	 * 
	 */
	public static int[] drop(int one) {
		int[] test = new int[10];
		for (int i=0; i<10; i++) {
			if (one % 2 == 1)
				test[i] = 1;
	        one = one >> 1;
		}
		return test;
	}

	public static int checkTest(int[] test) {
		int ret = 0;
		for (int i=9; i>=0; i--) {
			ret <<= 1;
			int c = test[i]==1 ? ret++ : 0;
		}
		return ret;
	}

	public static void main(String[] args) {
		// testing case
		int[] cas = drop(263);
		System.out.println( checkTest(cas) );
	}
}
