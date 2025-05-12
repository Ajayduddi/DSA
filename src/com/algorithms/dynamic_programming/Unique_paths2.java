// https://leetcode.com/problems/unique-paths-ii/description/

package com.algorithms.dynamic_programming;

public class Unique_paths2 {

	/*
	 * Define a DP Table: Create a 2D array dp[m][n], where dp[i][j] represents the
	 * number of unique paths from cell (i, j) to the bottom-right corner.
	 * 
	 * 
	 * Base Case Initialization:
	 *  - Last Column: Start from the bottom-most cell in the last column and move
	 * 	  upwards. If an obstacle is encountered, all cells above it are set to 0,
	 *    otherwise, they are 1 (since there is only one way to move down).
	 * 
	 * 
	 *  - Last Row: Start from the right-most cell in the last row and move leftwards.
	 *    If an obstacle is encountered, all cells to the left are set to 0, otherwise,
	 *    they are 1 (since there is only one way to move right). 
	 * 
	 * Bottom-Up Computation:
	 *  - Traverse the grid from the second last row (m-2) and second last column (n-2)
	 *   backward to (0, 0). If grid[i][j] == 1, set dp[i][j] = 0 (since it's an
	 *   obstacle). Otherwise, compute dp[i][j] = dp[i][j+1] + dp[i+1][j], meaning the
	 *   number of ways to reach the destination from (i, j) is the sum of paths from
	 *   the right (dp[i][j+1]) and bottom (dp[i+1][j]).
	 * 
	 * 
	 * Final Result: The answer is stored in dp[0][0], which gives the number of
	 * unique paths from the top-left (0, 0) to the bottom-right (m-1, n-1),
	 * considering obstacles.
	 * 
	 * Time Complexity : O ( m * n )
	 * Space Complexity :  O ( m * n )
	 */
	public static int uniquePathsWithObstacles(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];

		int obst = 0;
		for (int i = grid.length - 1; i >= 0; i--) {
			if (grid[i][grid[0].length - 1] == 1 && obst == 0) {
				obst = 1;
				dp[i][grid[0].length - 1] = 0;
			}

			if (obst == 1) {
				dp[i][grid[0].length - 1] = 0;
			}
			else {
				dp[i][grid[0].length - 1] = 1;
			}
		}

		obst = 0;
		for (int i = grid[0].length - 1; i >= 0; i--) {
			if (grid[grid.length - 1][i] == 1 && obst == 0) {
				obst = 1;
				dp[grid.length - 1][i] = 0;
			}

			if (obst == 1) {
				dp[grid.length - 1][i] = 0;
			}
			else {
				dp[grid.length - 1][i] = 1;
			}
		}

		for (int i = grid.length - 2; i >= 0; i--) {
			for (int j = grid[0].length - 2; j >= 0; j--) {
				if (grid[i][j] == 0) {
					dp[i][j] = dp[i][j + 1] + dp[i + 1][j];
				}
				else {
					dp[i][j] = 0;
				}
			}
		}

		return dp[0][0];
	}

	public static void main(String[] args) {
		System.out.println(uniquePathsWithObstacles(new int[][]{{0,0,0},{0,1,0},{0,0,0}}));
	}
}
