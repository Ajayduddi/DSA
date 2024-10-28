package com.datastructures.recursion;

public class RemoveString {

    public static void main(String[] args) {
        String str = "abcabcAjayDuddi";
        System.out.println(removeString(str, "Ajay"));
        System.out.println(removeAjayStringNotAjayDuddi(str));
    }

    static String removeString(String str, String remove) {
        if (str.length() == 0) {
            return "";
        }

        if (str.startsWith(remove)) {
            return removeString(str.substring(remove.length()), remove);
        }

        return str.charAt(0) + removeString(str.substring(1), remove);
    }
    

    // Remove 'Ajay' when its not starts with 'AjayDuddi'
    static String removeAjayStringNotAjayDuddi(String str) {
        if (str.length() == 0) {
            return "";
        }

        if (str.startsWith("Ajay") && !str.startsWith("AjayDuddi")) {
            return removeAjayStringNotAjayDuddi(str.substring("Ajay".length()));
        }

        return str.charAt(0) + removeAjayStringNotAjayDuddi(str.substring(1));
    }
}
