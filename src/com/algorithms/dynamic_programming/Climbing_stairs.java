// https://leetcode.com/problems/climbing-stairs/description/

package com.algorithms.dynamic_programming;

public class Climbing_stairs {

	/*
	 * Start with two variables a and b, representing the number of ways to reach
	 * the two previous steps (like Fibonacci numbers). 
	 * 
	 * Use a helper function ans() that takes a, b, count, and n to track progress. 
	 * 
	 * Base case: If count reaches n, return a + b — the total ways to reach the top from the last two steps.
	 * 
	 * Recursive step: Move to the next step by updating a to b and b to a + b (the
	 * next Fibonacci number), incrementing count. 
	 * 
	 * Repeat until the base case is met, returning the total number of ways to reach step n.
	 * 
	 * Time Complexity : O ( n )
	 * Space Complexity :  O ( n )
	 */
	public static int climbStairs(int n) {
		return ans(0, 1, 1, n);
	}

	public static int ans(int a, int b, int count, int n) {
		// base condition
		if (count == n) {
			return a + b;
		}

		return ans(b, (a + b), count + 1, n);
	}

	public static void main(String[] args) {
		System.out.println(climbStairs(20));
	}
}