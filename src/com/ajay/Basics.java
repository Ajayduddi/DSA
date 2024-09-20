package com.ajay;

import java.util.Scanner;

public class Basics {
    public static void main(String[] args) {

        //standard Output stream
        System.out.println("This is a Printing Statement in Java with new line");
        System.out.print("This cmd prints output in same line");
        System.out.print("  Demo ");

        /*
        Standard input stream
        Scanner is a class used to get input to the file.
        To create a object in java follow the syntax format
        className ObjName = new ClassName();
         */
        Scanner input = new Scanner(System.in);
        Scanner input2 = new Scanner("this is my input");
        System.out.println("\n\n"+input2.nextLine());

        // System.out.println("\nEnter Integer: ");
        // System.out.println(input.nextInt());
        System.out.println("\nstore full line with spaces: ");
        String hs = new String(input.nextLine());
        String hs1 = input.nextLine();
        System.out.println(hs + '\n' +hs1);

        //ignore under scores
        int a = 234_000_000;
        System.out.println(a);

        //primitive datatypes
        // only primitive datatypes are assigned by value and immutable
        byte bytenum = 3;
        short shortNum = 5345;
        int num = 31133;
        char character = 'A';
        float floatingPoints = 3232.3F;
        double longDecimal = 4344222.646633535;
        long longInteger = 42525252525252423L;
        boolean check = true;

        //primitive datatypes default values
        byte bytenum2;
        short shortnum2;
        int num2;
        char character2;
        float decimalPoint;
        double longDecimal1;
        long longInteger1;
        boolean check1;

//        System.out.println("premitive datatypes default values");
//        System.out.println("byte"+bytenum2);
//        System.out.println("short"+shortnum2);
//        System.out.println("int"+num2);
//        System.out.println("char"+character2);
//        System.out.println("float"+decimalPoint);
//        System.out.println("double"+longDecimal1);
//        System.out.println("long"+longInteger1);
//        System.out.println("boolean"+check1);

    }
}
