package com.datastructures.searching;

import java.util.Scanner;

public class LineaSearch {

    // It is a sequential search algorithm.
    // we simply traverse the list and search fot the required element .return the index if item found
    // otherwise return -1 item not found

    // Best Case Time Complexity: O(1)   if item found at first index
    // Worst Case Time Complexity: O(n)  if element not found or at last index

    public static void main(String[] args) {
        int[] nums = {2,2,2,343,45,454,31,313,12,121,212,131,32,435,35,465,63,423,24,23,132,31,31,31,13,30};
        String s = "Ajay Duddi";
        Scanner in = new Scanner(System.in);

        System.out.println("Enter element to search:");
        int target = in.nextInt();
        System.out.println("Enter character to search:");
        char c = in.next().trim().charAt(0);

        int ans = linearsearch(nums,target);
        boolean ans2 =stringSearch(s,c);

        if( ans != Integer.MAX_VALUE && ans != -1)  System.out.println("Element found at: "+ans);
        else System.out.println("Element Not Found");

        if(ans2) System.out.println("character Found");
        else
            System.out.println("Character not Found");
        in.close();
    }

    // search in the array: return the index if item found
    // if item not found return -1
    static int linearsearch(int[] arr,int target){
        if(arr.length == 0) return -1;

        //  run for loop
        for(int i=0; i<arr.length; i++){
            // check for the element at every index if it is = target
            int element = arr[i];
            if(element == target) return i;
        }

        // this line is executed when none of the above return statements are executed
        // hence the element is not found
        return -1;
    }

    // return the element if element found
    static int linearsearch2(int[] arr,int target){
        if(arr.length == 0) return Integer.MAX_VALUE;

        //  run for loop
        for(int element:arr){
            if(element==target) return element;
        }

        // this line is executed when none of the above return statements are executed
        // hence the element is not found
        // here not return -1 because the -1 may be a element. so return integer constant
        return Integer.MAX_VALUE;
    }


    // searching in the string
    static boolean stringSearch(String s,char target){
        if(s.isEmpty()) return false;

        // for loop
        for(char c:s.toCharArray()) {
            if(c==target) return true;
        }

        // this line is executed when none of the above return statements are executed
        // hence the element is not found
        return false;
    }
}
