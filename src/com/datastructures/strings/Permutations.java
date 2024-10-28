package com.datastructures.strings;

public class Permutations {

    public static void main(String[] args) {
        permut("", "abc");
    }
    
    static void permut(String p, String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String first = p.substring(0, i);
            String last = p.substring(i);
            permut(first+ch+last, up.substring(1));
        }
    }
}