package ch1;

public class Solution18 {
	
	/**
	 * I implemented two ways. One's Space complexity is O(n), the other is O(1)
	 * Algorithm: Mark zero tag with array
	 * Time: O(n^2)		Space: O(n)
	 * @param mat
	 */
	public static void zeroMatrix1(int[][] mat) {
		int n = mat.length, m = mat[0].length;
		
		boolean[] row = new boolean[mat.length];
		boolean[] col = new boolean[mat[0].length];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (mat[i][j] == 0) {
					row[i] = true;
					col[j] = true;
				}
			}
		}
		
		for (int i = 0; i < row.length; i++) {
			if (row[i]) {
				for (int j = 0; j < m; j++) {
					mat[i][j] = 0;
				}
			}
		}
		for (int i = 0; i < col.length; i++) {
			if (col[i]) {
				for (int j = 0; j < n; j++) {
					mat[j][i] = 0;
				}
			}
		}
	}
	
	/**
	 * Algorithm: Mark zero tag with matrix first row and column
	 * Time: O(n^2) 	Space: O(1)
	 * @param mat
	 */
	public static void zeroMatrix2(int[][] mat) {
		boolean isFirstRowZero = false;
		boolean isFirstColZero = false;
		int m = mat.length, n = mat[0].length;
		for (int i = 0; i < m; i++) {
			if (mat[i][0] == 0) {
				isFirstColZero = true;
				break;
			}
		}
		for (int j = 0; j < n; j++) {
			if (mat[0][j] == 0) {
				isFirstRowZero = true;
				break;
			}
		}
		
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][j] == 0) {
					mat[0][j] = 0;
					mat[i][0] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (mat[i][0] == 0 || mat[0][j] == 0) {
					mat[i][j] = 0;
				}
			}
		}
		if (isFirstRowZero) {
			for (int i = 0; i < n; i++)
				mat[0][i] = 0;
		}
		if (isFirstColZero) {
			for (int j = 0; j < m; j++)
				mat[j][0] = 0;
		}
	}
	
	public static void main(String[] args) {
		/**
		 * Testing cases.
		 */
		int[][] mat = {{1, 2, 3, 0}, {4, 5, 6, 7}, {7, 8, 9, 10}};
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("-----------");
		zeroMatrix2(mat);
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[0].length; j++) {
				System.out.print(mat[i][j] + " ");
			}
			System.out.println();
		}
	}
}
