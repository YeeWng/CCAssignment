package ch6;

public class Solution604 {

	/**
	 * Ch6 Question 6: Ants on a Triangle
	 * 
	 * Obviously, the ants will collide if any of them are moving towards each other.
	 * So the only way is the ants move in the same direction.
	 * 
	 * (1) Consider the possibility that they will not have collision. 
	 * The first ant can pick whichever direction but the rest of two ant must be the same direction of the first one. 
	 * So, #2 ant ,and #3 ant have two directions to choose respectively. 
	 * So there are (1/2) * (1/2) possibility that they can stay harmony. 
	 * So the collision happens possibility is :
	 * 		1 - (1/2) * (1/2) = 3/4
	 * 
	 * (2) Follow Up:  Calculate the probability for n ants and n-vertex polygon.
	 * The same idea, consider the possibility that they will not have collision.
	 * #1 can choose whatever direction, the following n-1 ants must the same direction as the first one. 
	 * So the non-collision probability is: 
	 * 		(1/2) ^ (n-1) 
	 * Therefore, the collision possibility is :
	 * 		1 - (1/2) ^ (n-1);
	 * 
	 */
}
