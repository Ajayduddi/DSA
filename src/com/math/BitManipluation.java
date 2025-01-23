package com.math;

public class BitManipluation {
    
    public static void main(String[] args) {
        bitWise_Operators();
        System.out.println();
        numberSystem();
        System.out.println(isEven(10));
    }
    
    public static void bitWise_Operators() {
        // Bitwise AND (&)
        byte a = 10; // 01010
        byte b = 20; //  10100
        /*
         * 10100 & 01010 = 00000
         */
        System.out.println("a & b = " + (a & b));

        // if you perform AND operation of 1 ( all 1's ) with any number. digits will be same. 
        // but if you perform AND operation of 0 ( all 0's ) with any number. digits will be 0.
        // if you perform AND operation with the same number. digits will be same.
        /*
         * 00001010 & 11111111 = 00001010
         * 00001010 & 00000000 = 00000000
         * 00001010 & 00001010 = 00001010
         */
        System.out.println("a & '11111111' = " + (a & 255));
        System.out.println("b & '00000000' = " + (b & 0));
        System.out.println("a & a = " + (a & a));

        // Bitwise OR (|)
        a = 10; // 01010
        b = 20; //  10100
        /*
         * 10100 | 01010 = 11110
         */
        System.out.println("a | b = " + (a | b));
        // if you perform OR operation of 1 ( all 1's ) with any number. Ans will be All 1's.
        // but if you perform OR operation of 0 ( all 0's ) with any number. Ans will be same as number.
        /*
         * 00001010 | 11111111 = 11111111
         * 00001010 | 00000000 = 00001010
         */
        System.out.println("a | '11111111' = " + (a | 255));
        System.out.println("b | '00000000' = " + (b | 0));

        // Bitwise XOR (^)
        a = 30; //  00011110
        b = 40; //  00101000
        /*
         * 00011110 ^ 00101000 = 00110110
         * the concept of a carry (which is used in arithmetic operations linke bineary addition, subtraction, multiplication, division) not in bitwise operations
         */
        System.out.println("a ^ b = " + (a ^ b));
        // if you perform XOR operation of 1 ( all 1's ) with any number. Ans will be complement of number.
        // if you perform XOR operation of 0 ( all 0's ) with any number. Ans will be same as number.
        // if you perform XOR operation with the same number. Ans will be 0.
        /*
         * 00001010 ^ 11111111 = 11111101
         * 00001010 ^ 00000000 = 00001010
         * 00001010 ^ 00001010 = 00000000
         */
        System.out.println("a ^ '11111111' = " + (a ^ 255));
        System.out.println("b ^ '00000000' = " + (b ^ 0));
        System.out.println("a ^ a = " + (a ^ a));

        // Bitwise NOT (~) [ complement ]
        a = 30; //  00011110
        /*
         * ~00011110 = 11100111
         */
        System.out.println("~a = " + (~a));


        // Bitwise Left Shift (<<)
        a = 10; // 00001010
        b = 2; //  0010
        /*
         * 00001010 << 2 = 00101000
         * 
         * general point = a << b = a * 2^b
         */
        System.out.println("a << b = " + (a << b));


        // Bitwise Right Shift (>>)
        a = 10; // 00001010
        b = 2; //  0010
        /*
         * 00001010 >> 2 = 000010
         * 
         * general point = a >> b = a / 2^b
         * which fills the leftmost bits with the sign bit (i.e., 0 for positive numbers and 1 for negative numbers).
         */
        System.out.println("a >> b = " + (a >> b));
        
        // Bitwise Unsigned Right Shift (>>)
        a = -10; // 00001010 ( ~ 10) == > 11111111 11111111 11111111 11110110 ( ~ -10) Two's complement
        b = 2; //  0010
        /*
         * 11111111 11111111 11111111 11110110 >>> 2 = 00111111 11111111 11111111 11111101
         * 
         * general point = a >> b = a / 2^b
         * It shifts the bits of a number to the right and fills the leftmost bits with 0, regardless of the sign of the number
         */
        System.out.println("a >>> b = " + (a >>> b));
    }

    public static void numberSystem() {
        // Decimal
        /*
         * 0,1,2,3,4,5,6,7,8,9
         * base 10
         */
        System.out.print("Decimal - ");
        System.out.print(" (365)base10 : " + 365);
        System.out.println();

        // Binary
        /*
         * 0,1
         * base 2
         */
        System.out.print("Binary - ");
        System.out.print(" (1010)base2 : " + 1010);
        System.out.println();

        // decimal to binary
        int decimal = 255;
        String binary = Integer.toBinaryString(decimal);
        System.out.print("decimal to binary - ");
        System.out.print((" (255)base10 : (" + binary + ")base2"));
        System.out.println();

        // bineary to decimal
        binary = "1010";
        decimal = Integer.parseInt(binary, 2);
        System.out.print("binary to decimal - ");
        System.out.print((" (1010)base2 : (" + decimal + ")base10"));
        System.out.println("\n");

        // Octal
        /*
         * 0,1,2,3,4,5,6,7
         * base 8
         */
        System.out.print("Octal - ");
        System.out.print(" (255)base8 : " + 255);
        System.out.println();

        // decimal to octal
        /*
         * decimal : 0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 .......
         * octal : 0,1,2,3,4,5,6,7,10,11,12,13,14,15,16,17,20,21,22,23 .......
         * binary : 0,1,10,11,100,101,110,111,1000,1001,1010,1011,1100,1101,1110,1111......
         */
        decimal = 11;
        String octal = Integer.toOctalString(decimal);
        /*
         * if you observe the above numbers
         * 11 in decimal  == 13 in Octal ( place wise )
         * 11 in decimal == 1011 o=in binary ( place wise )
         */
        System.out.print("decimal to octal - ");
        System.out.print((" (11)base10 : (" + octal + ")base8"));
        System.out.println();

        // octal to decimal
        octal = "13";
        decimal = Integer.parseInt(octal, 8);
        System.out.print("octal to decimal - ");
        System.out.print((" (13)base8 : (" + decimal + ")base10"));
        System.out.println("\n");

        // Hexadecimal (base 16)
        /*
         * 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F
         * base 16
         */
        System.out.print("Hexadecimal - ");
        System.out.print(" (255)base16 : " + 255); // 0000 0010 0101 0101
        System.out.println();

        // decimal to hexadecimal
        /*
         * decimal :     0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20 .......
         * hexadecimal : 0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F,10,11,12,13,14,15,16,17,18,19,1A.....
         */
        decimal = 255;
        String hexadecimal = Integer.toHexString(decimal);
        System.out.print("decimal to hexadecimal - ");
        System.out.print((" (255)base10 : (" + hexadecimal + ")base16"));
        System.out.println();

        // hexadecimal to decimal
        hexadecimal = "FF";
        decimal = Integer.parseInt(hexadecimal, 16);
        System.out.print("hexadecimal to decimal - ");
        System.out.print((" (FF)base16 : (" + decimal + ")base10"));
        System.out.println();
        hexadecimal = "14";
        decimal = Integer.parseInt(hexadecimal, 16);
        System.out.println("hexadecinal to decimal - (14)base16 : (" + decimal + ")base10");
        System.out.println("\n");

        /*
         * We can convert only from decimal to any number system. and vice versa.
         * We can't convert from any number system to any number system except decimal.
         * 
         * if you want to convert any number system to any number system. you have to convert it to decimal first and then convert it to other number system.
         * eg : binary to octal
         *      first convert binary to decimal.
         *      then convert decimal to octal.
         */

    }

    public static String isEven(int n) {
        /*
         * if LSB is 0 then number is even
         * if LSB is 1 then number is odd
         */

        // String num = Integer.toBinaryString(n);
        // if(num.charAt(num.length() - 1) == '0') {
        //     return "Even";
        // } else {
        //     return "Odd";
        // }

        // or
        /*
         * number & 1 == 0 means number is even
         * number & 1 == 1 means number is odd
         */
        return ( n & 1 ) == 0 ? "Even" : "Odd";
    }
}
