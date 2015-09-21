package ch1;

public class Solution17 {

	/**
	 * Algorithm: according to the layer of matrix (simulation)
	 * Time: O(n^2) 	Space: O(1)
	 * @param mat
	 */
	public static void rotate(int[][] mat) {
        if(mat == null || mat.length==0)
            return ;
 
        int n = mat.length;
    	for (int i = 0, len = n; i < n / 2; i++, len -= 2) {
    		int m = len - 1;
    		for (int j = 0; j < m; j++) { //Math.ceil(((double) n) / 2.)
    			int temp = mat[i][j];
    			mat[i][j] = mat[n-1-j][i];
    			mat[n-1-j][i] = mat[n-1-i][n-1-j];
    			mat[n-1-i][n-1-j] = mat[j][n-1-i];
    			mat[j][n-1-i] = temp;
    		}
    	}
    }
	
	public static void main(String[] args) {
		/**
		 * Testing cases
		 */
		int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------");
		rotate(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
