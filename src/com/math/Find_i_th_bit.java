package com.math;

public class Find_i_th_bit {
    
    public static void main(String[] args) {// index starts from 0
        System.out.println(findIthBit(5, 2));
    }
    
    static int findIthBit(int n, int i) {
        return (n & (1 << i)) >> i;
    }
}
