package com.datastructures.recursion;
import java.util.ArrayList;
import java.util.List;

// finding permutation of an array usinf recursion and backtracking
public class Permutation {
    public static void main(String[] args) {
        List<List<Integer>> list = permute(new int[] { 1, 2, 3 });
        List<List<Integer>> list2 = permute2(new int[] { 1, 2, 3 });
        System.out.println(list);
        System.out.println(list2);
    }
    
    static public List<List<Integer>> permute(int[] nums) {
        return helper(nums, new ArrayList<>(), 0);
    }

    static public List<List<Integer>> permute2(int[] nums) {
        return helper(nums, new ArrayList<>(), new boolean[nums.length]);
    }

    // method 1
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
            // add ch to p at index i
            p.add(i, ch);
            List<List<Integer>> temp = helper(up, p, index + 1);
            p.remove(i); // backtrack
            ans.addAll(temp);
        }

        return ans;
    }
    
    // method 2 
    // return the ArrayList of permutations in asscending order
    public static List<List<Integer>> helper(int[] up, List<Integer> p, boolean[] visited) {
        // find ans
        if (p.size() == up.length) {
            List<Integer> ans = new ArrayList<>();
            ans.addAll(p);
            return new ArrayList<>(List.of(ans));
        }

        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < up.length; i++) {
            if (!visited[i]) {
                // make visited true and add element to p [ processed ans ]
                visited[i] = true;
                p.add(up[i]);
                List<List<Integer>> temp = helper(up, p, visited);
                // backtrack
                p.remove(p.size() - 1);
                visited[i] = false;
                // add temp to final ans
                ans.addAll(temp);
            }
        }

        return ans;
    }
}
