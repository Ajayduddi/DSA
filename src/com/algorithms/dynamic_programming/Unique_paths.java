// https://leetcode.com/problems/unique-paths/

package com.algorithms.dynamic_programming;

public class Unique_paths {
	
	/*
	 * Define a DP Table: Create a 2D array dp[m][n], where dp[i][j] represents the
	 * number of unique paths from (i, j) to the bottom-right corner. Base Case
	 * 
	 * Initialization: The last row (m-1) and last column (n-1) are set to 1 because
	 * there is only one way to reach the destination from these positions (either
	 * moving right or down).
	 * 
	 *  Bottom-Up Computation: Iterate from the second last row (m-2) and column (n-2) 
	 * backward to (0, 0). Each cell's value is computed as dp[i][j] = dp[i][j+1] + dp[i+1][j], 
	 * meaning the number of ways to reach the bottom-right cell is the sum of ways from the right and bottom cells.
	 * 
	 * Final Result: The answer is stored in dp[0][0], which gives the number of
	 * unique paths from the top-left corner (0,0) to (m-1,n-1).
	 * 
	 * 
	 * Time Complexity : O ( m * n )
	 * Space Complexity :  O ( m * n )
     *
	 */
	public static int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];

		for (int i = 0; i < m; i++)
			dp[i][n - 1] = 1;
		for (int i = 0; i < n; i++)
			dp[m - 1][i] = 1;

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
			}
		}

		return dp[0][0];
	}
	 
	public static void main(String[] args) {
		System.out.println(uniquePaths(5, 4));
	}
}
