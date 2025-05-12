// https://www.naukri.com/code360/problems/partition-equal-subset-sum_892980?leftPanelTabValue=PROBLEM&count=25&page=1&search=partition%20&sort_entity=order&sort_order=ASC&customSource=studio_nav

/*
 * Buttom up dp
 */

package com.algorithms.dynamic_programming;

public class Partition_equal_subset_sum {

    public static boolean[][] dp;
	public static boolean canPartition(int[] arr, int n) {

        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }

        if(totalSum % 2 != 0){
            return false;
        }

        dp = new boolean[n + 1][totalSum];
		boolean res = helper(arr, 0, 0, totalSum / 2);
        return res;
	}

	public static boolean helper(int[] arr, int i, int sum1, int sum2){
		// base condition
		if(i >= arr.length){
			if(sum1 == sum2){
				return true;
			}
			return false;
		}

        if(sum1 == sum2){
            return true;
        }

		// check dp
		if(dp[i][sum1]){
			return dp[i][sum1];
		}

		for(int j = i; j < arr.length; j++){
			boolean res = helper(arr, i+1, sum1 + arr[i], sum2);
			if(res){
				dp[i][sum1] = res;
				return res;
			}

			res = helper(arr, i+1, sum1, sum2);
			dp[i][sum1] = res;
		}

		return dp[i][sum1];
	}

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{77, 89, 87, 78, 56, 86, 12, 15, 11, 12, 76, 7, 12, 20, 31, 52}, 16));
    }
}
