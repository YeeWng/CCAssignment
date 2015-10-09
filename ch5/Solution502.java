package ch5;

public class Solution502 {

	/**
	 * Ch5 Question 2: Binary to String
	 * Method: Adapting version of multiply 2. 
	 * 		   Instead of multiply 2 every time, we can change the base number by divide 2
	 * 
	 * Time: O(n) [n is the bits number]
	 * Space: O(1)
	 * 
	 */
	
	// EPS for double comparasion
	final static double EPS = 1e-8;
	
	public static String toBinary(double num) {
		if (num <= 0 || num >= 1)
			return "ERROR";
		
		double frac = 0.5;
		StringBuilder s = new StringBuilder(".");
		while ( num - 0.0 > EPS ) {
			if (s.length() > 32) 
				return "ERROR";

			if (num >= frac) {
				s.append(1);
				num -= frac;
			} else {
				s.append(0);
			}
			frac /= 2;
		}
		return s.toString();
	}
	
	public static void main(String[] args) {
		double num = 0.72; 
		System.out.println("(" + num +") Binary: " + toBinary(num));
	}

}
