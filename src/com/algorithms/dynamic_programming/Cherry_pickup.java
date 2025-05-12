// https://leetcode.com/problems/cherry-pickup-ii/
package com.algorithms.dynamic_programming;

import java.util.*;

public class Cherry_pickup{

    public static Map<String, Integer> dp = new HashMap<>();

    public static int cherryPickup(int[][] grid) {
        return helper(grid, 0, 0, grid[0].length - 1);
    }

    public static int helper(int[][] grid, int i, int j, int y)
    {
        // base condition
        if(i >= grid.length){
            return 0;
        }

        if(j < 0 || j >=  grid[0].length || y < 0 || y >=  grid[0].length){
            return 0;
        }

        // check dp
        String s = i + "," + j+ "," + y;
        if(dp.containsKey(s)){
            return dp.get(s);
        }

        int max = Integer.MIN_VALUE;
        for (int k = -1; k <= 1; k++) {
            for (int k2 = -1; k2 <= 1; k2++) {
                int res = helper(grid, i + 1, j + k, y + k2);
                max = Math.max(max, res);
            }
        }
        
        int res = grid[i][j] + ( j != y ? grid[i][y] : 0 );
        dp.put(s, res + max);
        return dp.get(s);
    }

    public static void main(String[] args) {
        int[][] grid = new int[][] { {3,1,1},{2,5,1},{1,5,5},{2,1,1} };
        System.out.println(cherryPickup(grid));
    }
}