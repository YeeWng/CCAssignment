package ch6;

public class Solution608 {

	/**
	 * Ch6 Question 6: Two eggs and 100 floor:
	 * 
	 * We still can think from the basic case:
	 * 1. If we have on egg, we can drop it level by level from the bottom floor. 
	 * 2. If we have two levels, the naive thought is that we can check the range. e.g. throw at 10th, 20th, 30th..and then level by level in the range.
	 * 3. Then we take the times we use into consideration: 
	 * 
	 * Let us assume we drop our first egg from floor n, if it breaks, we can step through the previous (n-1) floors level-by-level
	 * If it doesn’t break, rather than jumping up another n floors, we should step up just (n-1) floors, so the next floor we should try is floor n + (n-1)
	 * Similarly, if this drop still does not break, we next need to go to floor
	 * n + (n-1) + (n-2), then floor n + (n-1) + (n-2) + (n-3)
	 * 
	 * We keep reducing the step by one each time we jump up, until that step-up is just one floor, and get the following equation for a 100 floors building:
	 * 
	 * n + (n-1) + (n-2) + (n-3) + (n-4) + … + 1  >=  100
	 * 
	 * Then we have: n (n+1) / 2  >=  100
	 * 
	 * The result of it is n = 13.651 => n = 14.
	 * 
	 * Follow up: n eggs and m floor. Please extend this question.
	 * 
	 * My code gives the basic solution.
	 * 
	 * 
	 * Solution: DP. 
	 * Will update soon...
	 * 
	 */
    
    public static int count(int which){
        int max = 100;
        int counts = 0;
        int gap = 14;
        int egg1 = 0, egg2 = 0;

        for (egg1 = gap; egg1 <= max; egg1 += gap) {
            counts++;
            if (egg1 >= which)
                break;
            gap--;
        }

        // break floor should be [egg1-gap+1, egg1]
        for (egg2 = egg1-gap+1; egg2 < egg1; egg2++) {
            counts++;
            if (egg2 == which)
                return counts;
        }

        return counts;
    }
    
    public static void main(String[] args) {
    	
        System.out.println(count(50));
    }
}
