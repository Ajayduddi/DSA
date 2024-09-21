package com.datastructures.searching;

import java.util.Scanner;

/**
 * Flooring The Number is a searching algorithm that finds the greatest integer in the array smaller than or equal to the target number
 * It is solved usinf Binary Search
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class FlooringTheNumber {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 31, 44, 65, 78, 99, 100 };
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the number: ");
        int target = in.nextInt();

        int ans = Floor(arr, target);
        System.out.println("The greatest integer smaller than or equal to " + target + " is " + ans);
        in.close();
    }
    
    static int Floor(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target)
                return arr[mid];
            else if (arr[mid] > target)
                end = mid - 1;
            else
                start = mid + 1;
        }

        return arr[end];
    }
}
