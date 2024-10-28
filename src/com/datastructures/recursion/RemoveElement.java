package com.datastructures.recursion;

public class RemoveElement {
    
    public static void main(String[] args) {
        String str = "abcabcabc";
        StringBuilder ans = new StringBuilder();
        System.out.println(removeElement(str, 'a'));
        removeElement(str, 'a', ans);
        System.out.println(ans);
    }
    
    // return ans without argument
    static String removeElement(String str, char ch) {
        if (str.length() == 0) {
            return "";
        }

        if (str.charAt(0) != ch) {
            return str.charAt(0) + removeElement(str.substring(1, str.length()), ch);
        }

        return removeElement(str.substring(1, str.length()), ch);
    }

    // return ans with argument
    static void removeElement(String str, char ch, StringBuilder ans) {
        if (str.length() == 0) {
            return;
        }

        if (str.charAt(0) != ch) {
            ans.append(str.charAt(0));
        }

        removeElement(str.substring(1, str.length()), ch,ans);
    }
}
