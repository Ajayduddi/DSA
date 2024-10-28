package com.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> ans = new ArrayList<>();

        // unique arrays
        subSet(new ArrayList<>(), arr, ans);
        System.out.println(ans);
        System.out.println();

        ans = subSet(arr);
        System.out.println(ans);
        System.out.println();

        // dupliacte arrays
        arr = new int[] { 1, 2, 2, 3 };
        ans = new ArrayList<>();
        subSetDuplicates(new ArrayList<>(), arr, ans);
        System.out.println(ans);
    }
    
    // print all sub-sets of a string using recursion
    // o(n)
    /*
     * p - processed
     * up - unprocessed
     */
    static void subSet(ArrayList<Integer> p, int[] up, List<List<Integer>> ans) {
        if (up.length == 0) {
            if (!p.isEmpty()) {
                ans.add(p);
            }
            return;
        }

        // subset pattern is taking element from unprocessed arr and removing element from arr string
        subSet(p, Arrays.copyOfRange(up, 1, up.length), ans); // removing element
        p = new ArrayList<>(p);
        p.add(up[0]);
        subSet(p, Arrays.copyOfRange(up, 1, up.length), ans); // taking element
    }

    // print all sub-set of a string using iteration
    // O(n^2)
    static List<List<Integer>> subSet(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        List<Integer> full = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            outer.add(Arrays.asList(arr[i]));
            full.add(arr[i]);

            for (int j = i + 1; j < arr.length; j++) {
                outer.add(Arrays.asList(arr[i], arr[j]));
            }
        }
        outer.add(full);

        return outer;
    }

    // print all sub-set of a string using using recursion and handling duplicates
    static void subSetDuplicates(ArrayList<Integer> p, int[] up, List<List<Integer>> ans) {
        if (up.length == 0) {
            if (!p.isEmpty() && !ans.contains(p)) {
                ans.add(p);
            }
            return;
        }

        // subset pattern is taking element from unprocessed arr and removing element from arr string
        subSetDuplicates(p, Arrays.copyOfRange(up, 1, up.length), ans); // removing element
        p = new ArrayList<>(p);
        p.add(up[0]);
        subSetDuplicates(p, Arrays.copyOfRange(up, 1, up.length), ans); // taking element
    }
}
