package com.datastructures.searching;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {

    // It is a Optimised Searching algorithm
    // Binary Search is works on sorted arrays only. It is works on Divide and Conquer approach
    // Its find the position of a target value by repeatedly dividing the search interval in half until the target value is found or the interval is empty

    // Time Complexity: O(log n)
    // Space Complexity: O(1)

    public static void main(String... args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 31, 44, 65, 78, 99, 100 };
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number to be searched");
        int target = in.nextInt();

        int ans = binarySearch(arr, target);
        if (ans == -1)  System.out.println("Element not found");
        else System.out.println("Element found at index " + ans);
        
        // close the scanner
        in.close();
    }

    
    // First Divide the search space into two halves by finding the middle index “mid”. 
    // Compare the middle element with the key. If the key is found at middle element, the process is terminated.
    // If the key is not found at middle element, choose which half will be used as the next search space.
    // If the key is smaller than the middle element, then the left side is used for next search.
    // If the key is larger than the middle element, then the right side is used for next search.
    // This process is continued until the key is found or the total search space is exhausted.

 
    static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        // find the middle index
        // int mid = (start + end) / 2; // Might be possible that (start + end) exceeds the range of int in java

        while (start <= end) {
            // efficirnt way to find mid
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        
        return -1;
    }
}
