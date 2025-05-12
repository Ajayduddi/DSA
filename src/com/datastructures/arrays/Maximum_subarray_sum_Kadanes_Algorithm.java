// https://leetcode.com/problems/maximum-subarray/description/

package com.datastructures.arrays;

public class Maximum_subarray_sum_Kadanes_Algorithm {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    /*
     * Initialize sum = 0 and max = nums[0].
     * 
     * Iterate through the array:
     * - Add the current element to sum.
     * - Update max if sum is greater than max.
     * - If sum becomes negative, reset it to 0 (because a negative sum will not
     *   contribute to the maximum subarray).
     * 
     * Return max, which contains the maximum subarray sum.
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0, max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }
}
