package com.datastructures.sorting;

import java.util.Arrays;

// Use cyclic sort when given numbers in range from 1 to N ; distinct values
/*
 * array : { 3, 5, 2, 1, 4 } , N = 5 ( total no of elements )
 * here we observe that the no present in the array is in the range of 1 to 5 (N)
 */
public class CyclicSort {
    public static void main(String[] args) {
        int[] arr = { 3, 5, 2, 1, 4  };
        cyclicSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    
    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int correct = arr[i] - 1; // get the correct index of the number
            // check weather the number is present at the correct index or not
            // If the number is present at the correct index, increment i
            // else swap the number with the correct index
            if (arr[i] == arr[correct]) {
                i++;
            } else {
                int temp = arr[correct];
                arr[correct] = arr[i];
                arr[i] = temp;
            }
        }
    }
}


/*
 * Approach :
 * 
 * 1. Cyclic sort is based on the idea of swapping the elements with the correct index
 * 2. The correct index is calculated by subtracting 1 from the number
 * 3. If the number is present at the correct index, increment i
 * 4. Else swap the number with the correct index
 * 
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */