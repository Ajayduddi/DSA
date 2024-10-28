package com.datastructures.strings;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    
    public static void main(String[] args) {
        subSeq("", "abc");
        List<String> arr = subSeq("abc");
        System.out.println(arr);
    }
    
    // print all sub-sequences of a string using recursion
    // o(n)
    /*
     * p - processed
     * up - unprocessed
     */
    static void subSeq(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        // subset pattern is taking element from unprocessed string and removing element from unprocessed string
        subSeq(p + up.charAt(0), up.substring(1)); // taking element
        subSeq(p, up.substring(1)); // removing element
    }

    // print all sub-sequence of a string using iteration
    // O(n^2)
    static List<String> subSeq(String str) {
        List<String> arr = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            arr.add(str.charAt(i) + "");

            for (int j = i + 1; j < str.length(); j++) {
                arr.add("" + str.charAt(i) + str.charAt(j));
            }
        }
        arr.add(str);

        return arr;
    }
}   
