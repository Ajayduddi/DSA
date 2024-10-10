package com.datastructures.strings;

public class StringBuilders {
    
    /* string is a seqence of characters ( character literals ). Write in "".
     * stringBuilder object strings are mutable . and not thread safe.
     * these objects are doesn't sorted in a string constant pool like string class objects. 
     * it is stroed in regular heap memory.
     * 
     * it is used when string is regularly changed and we want to avoid creating new object.
    */

    public static void main(String[] args) {
        
        // way of initializing string builder object
        StringBuilder series = new StringBuilder();
        StringBuilder sb;
        sb = new StringBuilder("Ajay");
        System.out.println(sb);

        // StringBuilder sb2;     // we cannot use sb2 with out initilization.
        // System.out.println(sb2);

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('a' + i);
            // series + ch;   we cannot perform operation like this on string builder object
            // any operation is performed using methods only
            // adding character to string builder object
            series.append(ch);
        }

        System.out.println(series);


        // methods
        System.out.println(sb.append(87567658)); // append() method appends the specified object to the end of this string builder
        System.out.println(sb.insert(0, "Duddi ")); // insert() method inserts the specified object into this string builder at the specified offset
        System.out.println(sb.deleteCharAt(10)); // deleteCharAt() method deletes the character at the specified index
        System.out.println(sb.delete(0, 6)); // delete() method deletes the characters in a substring of this string builder
        System.out.println(sb.replace(0, 6, "Duddi ")); // replace() method replaces the characters in a substring of this string builder with the specified string
        System.out.println(sb.reverse()); // reverse() method reverses the characters in this string builder
        System.out.println(sb.subSequence(0, 6)); // subSequence() method returns a new string that is a subsequence of this string builder
    }
}
