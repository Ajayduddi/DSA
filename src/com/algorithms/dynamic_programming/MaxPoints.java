package com.algorithms.dynamic_programming;

import java.util.*;

public class MaxPoints {
    public static int maxPoints(int[][] points) {
        // base case
        if(points.length == 1){
            return 1;
        }

        int count = 0;

        for(int i = 0; i < points.length; i++){
            int temp = 1;
            Map<String, Integer> map = new HashMap<>();
            for(int j = i + 1; j < points.length; j++){
                    double res = (double)( points[j][0] - points[i][0] ) / ( points[j][1] - points[i][1] );
                    if(Double.isInfinite(res)){
                        map.computeIfAbsent(res+"", k -> 0);
                        map.put(res+"", map.get(res+"") + 1);
                    }
                    else{
                        res = Math.abs(res);
                        map.computeIfAbsent(""+res, k -> 0);
                        map.put(""+res, map.get(""+res) + 1);
                    }
            }

            int max = -1;
            for( String ele : map.keySet()){
                if(map.get(ele) > max){
                    max = map.get(ele);
                }
            }

            if(temp + max > count){
                count = temp + max;
            }
        } 

        return count;
    }

    public static void main(String[] args){
        System.out.println(maxPoints(new int[][]{ {2,3},{3,3},{-5,3} }));
    }
}