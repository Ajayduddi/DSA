package com.datastructures.strings;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    public static void main(String[] args) {
        permut("", "abc");
        List<List<Integer>> ans = permute(new int[] { 1, 2, 3 });

        System.out.println();
        for (List<Integer> list : ans) {
            for (Integer ele : list) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }

    // using recursion only without backtracking
    static void permut(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i);
            permut(first + ch + last, up.substring(1));
        }
    }

    // with backtracking
    public static List<List<Integer>> permute(int[] nums) {
        return helper(nums, new ArrayList<>(), 0);
    }

    public static List<List<Integer>> helper(int[] up, List<Integer> p, int index) {
        // after find solution
        if (index == up.length) {
            List<Integer> ans = new ArrayList<>();
            ans.addAll(p);
            return new ArrayList<>(List.of(ans));
        }

        int ch = up[index];
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i <= p.size(); i++) {
            // add ch to p
            p.add(i, ch);
            List<List<Integer>> temp = helper(up, p, index + 1);
            p.remove(i); // backtrack
            ans.addAll(temp);
        }

        return ans;
    }
}

/*
 * In Permutations we need to finding all possible arrangements of the given numbers.
 * Example: For {1, 2, 3}, permutations include:
 *  - {1,2,3}, {1,3,2}, {2,1,3}, {2,3,1}, {3,1,2}, {3,2,1}
 * 
 * In Combinations You’re choosing subsets of the numbers, and the relative order doesn’t affect the result.
 * Example: For {1, 2, 3}, combinations of size 2 are:
 *  - {1,2}, {1,3}, {2,3} ( {2,1} — it's the same as {1,2}).
 * Same elements in a different order count as the same combination.
 */