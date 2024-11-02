package com.math;

public class FindUnique {
    
    public static void main(String[] args) {
        int[] arr = { 2, 3, 2, 5, 6, 5, 3, 6, 7 };
        System.out.println(findUnique(arr));
    }
    
    // time complexity = O(n)
    public static int findUnique(int[] arr) {
        // perform the xor operation on all the elements of the array
        int ans = 0;
        for (int i : arr) {
            ans ^= i;
        }

        return ans;
    }
}
