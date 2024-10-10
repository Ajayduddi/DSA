package com.datastructures.strings;

import java.util.ArrayList;
import java.util.Arrays;

public class Strings {
    /* string is a seqence of characters ( character literals ). Write in "".
     * string are immutable . and thread safe.
     * In c/c++ string is a pointer to a char array
     * but in java string is a object of String class. so, it is assigned to the variable by reference.
     * Actually, these objects are sorted in a string constant pool. ( string pool are present in heap space )
     * 
    */

    public static void main(String[] args) {

        // here s1,s2 are pointing to the same object
        String s1 = "hello";
        String s2 = "hello";

        // Return true if two variables refer to the same object
        System.out.println(s1 == s2); // for strings '==' is used to chcek both variables refer to the same object or not

        // return true if the both variables have same value
        System.out.println(s1.equals(s2));

        // changing the value of s2
        s2 = "world  ";

        // in generally s1 and s2 are pointing to the same object.
        // change in one variable will reflect in other variable. because both varibles are refering to same object, the object is mutable.

        // here we observe that previously s1 and s2 are pointing to the same object
        // after changng s2 to "world". the new object is creating in constant pool and the variable s2 is pointing to that object.
        // so, s1 and s2 are pointing to different object. because it is immutable.
        System.out.println(s1);
        System.out.println(s2);


        // convert string to char array
        String[] split = s1.split(""); // if use split() method, it will spilt the string into Array of strings based on regex, we cannot join array of string to string
        System.out.println(Arrays.toString(split));
        // or
        char[] chars = s1.toCharArray(); // it will create character array and it is possible to convert into string
        System.out.println(Arrays.toString(chars));

        // convert char array to string ( joiniing the char array )
        System.out.println(String.valueOf(chars)); // `valueOf()` method returns a string that is the string representation of the specified character array
        System.out.println(new String(chars));

        // String methids
        System.out.println(s2.charAt(0)); // `charAt()` method returns the character at the specified index
        System.out.println(s2.length()); // `length()` method returns the length of the string
        System.out.println(s2.indexOf("l")); // `indexOf()` method returns the index of the first occurrence of the specified character in the string
        System.out.println(s2.lastIndexOf("l")); // `lastIndexOf()` method returns the index of the last occurrence of the specified character in the string
        System.out.println(s2.substring(1, 3)); // `substring()` method returns a new string that is a substring of this string
        System.out.println(s2.toUpperCase()); // `toUpperCase()` method returns a string that is the same as this string but with all characters converted to uppercase
        System.out.println(s2.toLowerCase()); // `toLowerCase()` method returns a string that is the same as this string but with all characters converted to lowercase
        System.out.println("   Trimmed string    ".trim() ); // `trim()` method returns a string that is the same as this string but with all leading and trailing whitespace removed
        System.out.println("   Trimmed string    ".strip()); // `strip()` method returns a string that is the same as this string but with all leading and trailing whitespace removed
        System.out.println(s1.concat(s2)); // `concat()` method returns a string that is the concatenation of this string and the specified string
        System.out.println(s1.contains("a")); // `contains()` method returns true if and only if this string contains the specified sequence of char values

        // printf
        System.out.printf("%s %s", s1, s2);

        //  operations
        System.out.println('a' + 'b'); // return sum of its Ascii value ( 97 + 98 = 195 ). 
        // because if we perform arithemitic operation on character, it will perform on their its Ascii value
        System.out.println('a' + 1); // return 98

        System.out.println("a" + "b"); // return ab
        // because operation is perform on string not their on its Ascii value
        System.out.println("a" + 1); // return a1
        // because if we sum string + integer( or any object) then it will convert into its wrapper class object and call toString().
        // after few steps : "a"+ "1"
        System.out.println("Ajay" + new ArrayList<>()); // return Ajay[]
        
        // '+' operator is work with premitive data types and all complex objects , but the condition is any onee of the object should be a string. and return string
    }
}
