package ch6;

public class Solution607 {

	/**
	 * Ch6 Question 7: The Apocalypse:
	 * 
	 * Suppose B as boy, G as girl 
	 * 
	 * Start from basic cases:
	 * (1) The first one is : 1/2; The boy number * prob = 0.
	 * (2) BG : 	Prob : (1/2)^2 = 1/4, boy number * prob : 1/4
	 * (3) BBG : 	Prob : (1/2)^3 = 1/8, boy number * prob: 2/8
	 * (4) BBBG : 	Prob : (1/2)^4 = 1/16, boy number * prob: 3/16
	 * 
	 * And so on, then the total ratio G/B should be :
	 * Ratio = (Sum of (i / (2^i)) here (0 < i < Inf))
	 * 
	 * So we easily know, the ratio is: 50% girls, 50% boys. 
	 * 
	 */
	
    public static void main(String[] args) {
    	// testing case
        System.out.println( radio(1000000) );
    }
    
    public static double radio(int n) {
        double boys = 0, girls = 0;
        for (int i = 1; i < n; i++) {
        	while ( Math.random() >= 0.5 )
                boys++;
            girls++;
        }
        return girls / (boys+girls);
    }

}
