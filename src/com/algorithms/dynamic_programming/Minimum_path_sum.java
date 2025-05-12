// https://leetcode.com/problems/minimum-path-sum/description/

package com.algorithms.dynamic_programming;

public class Minimum_path_sum {

	public static int minPathSum(int[][] grid) {
		int[][] dp = new int[grid.length][grid[0].length];

		for (int i = grid.length - 1; i >= 0; i--) {
			if (i == grid.length - 1) {
				dp[i][grid[0].length - 1] = grid[i][grid[0].length - 1];
			}
			else {
				dp[i][grid[0].length - 1] = grid[i][grid[0].length - 1] + dp[i + 1][grid[0].length - 1];
			}
		}

		for (int i = grid[0].length - 1; i >= 0; i--) {
			if (i == grid[0].length - 1) {
				dp[grid.length - 1][i] = grid[grid.length - 1][i];
			}
			else {
				dp[grid.length - 1][i] = grid[grid.length - 1][i] + dp[grid.length - 1][i + 1];
			}
		}

		for (int i = grid.length - 2; i >= 0; i--) {
			for (int j = grid[0].length - 2; j >= 0; j--) {
				int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
				dp[i][j] = grid[i][j] + min;
			}
		}

		return dp[0][0];
	}
	
	public static void main(String[] args) {
		System.out.println(minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
	}
	
}