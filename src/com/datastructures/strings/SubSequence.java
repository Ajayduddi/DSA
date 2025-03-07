package com.datastructures.strings;

import java.util.ArrayList;
import java.util.List;


/*
 * Subset (of a set)
 * A subset of a set contains any selection of elements from the original set, without considering order or adjacency.
 * If S = {a, b, c}, then {a, c} is a valid subset.
 *
 * Example of a Factor (Substring): 
 * Consider the string: S = "abcdef"
 * - "abc" is a factor (substring) of S because the characters appear consecutively. 
 * - "cde" is also a factor because the characters appear together in S. 
 * - "ace" is not a factor because the characters are not consecutive in S.
 * 
 * Contrast with a Subsequence: A subsequence is a more general concept where
 * characters can appear in the same order but do not have to be consecutive.
 * 
 * For the same string S = "abcdef":
 * 
 * "ace" is a subsequence because a, c, and e appear in the same order, but not consecutively. 
 * "cfa" is not a subsequence because the order does not match.
 * 
 * Key Difference: A factor (substring) must be contiguous. A subsequence only
 * needs to maintain the relative order, but the characters do not have to be
 * consecutive.
 */
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


/*
 * 
 * Concept      Order Matters?    Consecutive Required?     Example ("abcdef")  
 * Subset           No                  No                   {a, c, f} (as a set) 
 * Substring        Yes                 Yes                      "bcd" 
 * Subsequence      Yes                 No                       "ace"
 * 
 */