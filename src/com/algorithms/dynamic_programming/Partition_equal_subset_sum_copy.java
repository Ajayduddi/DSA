// https://www.naukri.com/code360/problems/partition-equal-subset-sum_892980?leftPanelTabValue=PROBLEM&count=25&page=1&search=partition%20&sort_entity=order&sort_order=ASC&customSource=studio_nav
/*
 * top down dp
 */

package com.algorithms.dynamic_programming;

import java.util.HashMap;
import java.util.Map;

public class Partition_equal_subset_sum_copy {

    public static Map<String, Boolean> dp;

	public static boolean canPartition(int[] arr, int n) {
		// Write your code here.
		dp = new HashMap<>();
		return helper(arr, 0, 0,0);
	}

	public static boolean helper(int[] arr, int i, int sum1, int sum2){
		// base condition
		if(i >= arr.length){
			if(sum1 == sum2){
				return true;
			}
			return false;
		}

		// check dp
		String s = i + "," + sum1 + "," +sum2;
		if(dp.containsKey(s)){
			return dp.get(s);
		}

		for(int j = i; j < arr.length; j++){
			boolean res = helper(arr, i+1, sum1 + arr[i], sum2);
			if(res){
				dp.put(s, res);
				return res;
			}

			res = helper(arr, i+1, sum1, sum2 + arr[i]);
			dp.put(s,res);
		}

		return dp.get(s);
	}

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{8, 7, 6, 12, 4, 5}, 6));
    }
}
