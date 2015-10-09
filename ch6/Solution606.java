package ch6;

public class Solution606 {

	/**
	 * Ch6 Question 6: Blue-Eyes:
	 * 
	 * Assume n is number of blue-eyed people. 
	 * 
	 * If n = 1, the man must leave the first night as there are at least on blue eye.
	 * If n = 2, we assume they are A and B. A do not know himself eye color, neither B. So, they will not take action in the first day. In the second day, they know each other is still there, so there are 2 blue-eyed people. A and B both know they should leave. 
	 * If n = 3, the same idea, A, B, C know there maybe 1, 2 or 3 blue-eyed, after two days, no one leaves, they all know themselves are blue-eyed, So they will leave in the third day.  
	 * ...
	 * If n = N, these people know that there must be N-1 other people have blue eyes and maybe himself has or not. After N-1 night these people did not leave, so he recognize himself with blue eye. Thus, he will leave after n nights.
	 * So, if there are N blue-eyed people in the island, it will take them N days to leave.
	 * 
	 */
}
