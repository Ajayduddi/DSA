package com.algorithms.dynamic_programming;

	/*
	 * Frog Jump Problem:
	 * 
	 * A frog is initially at the first stone in a sequence. The frog can jump either to the next stone
	 * or skip one stone and jump to the stone after next. Every jump costs energy equal to the absolute
	 * difference in the heights of the stones it jumps between.
	 * 
	 * Given an array of integers "stones" where each element represents the height of a stone, write a 
	 * method to compute the minimum energy required for the frog to reach the last stone.
	 * 
	 * Constraints:
	 * - The array will have at least 2 elements.
	 * - The jump cost is defined as: |heights[i] - heights[j]|.
	 * 
	 * Example:
	 * Input: stones = [10, 30, 40, 20]
	 * Output: 30
	 * 
	 * Explanation:
	 * - Jump from stone 0 to stone 1: cost = |10 - 30| = 20
	 * - Jump from stone 1 to stone 3: cost = |30 - 20| = 10
	 * Total minimum cost = 20 + 10 = 30.
	 */
public class Frog_jump {
	public static void main(String[] args) {
		int[] stones = new int[] { 30, 10, 60, 10, 60, 50 };
		int[] dp = new int[stones.length];
		System.out.println(minEnergy(stones, dp, stones.length - 1));
	}
	
	public static int minEnergy(int[] stones, int[] dp, int index) {
		// base condition
		if (index == 0) {
			return 0;
		}

		if (dp[index] != 0) {
			return dp[index];
		}

		int left = minEnergy(stones, dp, index - 1) + Math.abs(stones[index] - stones[index - 1]);
		int right = Integer.MAX_VALUE;
		if (index > 1) {
			right = minEnergy(stones, dp, index - 2) + Math.abs(stones[index] - stones[index - 2]);
		}
		
		dp[index] = Math.min(left, right);
		return dp[index];
	}
}
