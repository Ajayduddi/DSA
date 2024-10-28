package com.datastructures.recursion;

public class BinearySearch {
    
    public static void main(String[] args) {
        int arr[] = new int[] {1,2,3,4,7,8,9,11,12,15,18,20,25,29,30};
        System.out.println("25 is find at index : "+ search(arr, 27));
    }
    
    static int search(int[] arr, int target) {
        return helper(arr, target,  0, arr.length - 1);
    }

    static int helper(int[] arr, int target, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                return helper(arr, target, start, mid - 1);
            } else {
                return helper(arr, target, mid + 1, end);
            }
        }
        
        return -1;
    }
}
