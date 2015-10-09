package ch6;

public class Solution602 {
	
	/**
	 * BasketBall:
	 * 
	 * For Game 1 : Win Prob: p 
	 * For Game 2 : Prob = P(select 2 from 3 shots) * p * p * (1-p) +  P(select 3 from 3 shots ) * (p ^ 3)
	 * 					 =  3 * (1 - p) * p^2 + p^3 
	 * 					 =  3 * p^2 - 2 * p^3;
	 * 
	 * We should discuss the value of p: 
	 * If Game 1 is better than Game2 : p > 3p^2 - 2p^3
	 * 								=>	(2p - 1)(p - 1)  => p < 0.5 
	 * 
	 * So, if p = 0.5 we can select either Game 1 or Game 2.
	 * 	   if p < 0.5 we should play Game 1.
	 *     if p > 0.5 we should play Game 2.
	 *     
	 *      
	 */

}
