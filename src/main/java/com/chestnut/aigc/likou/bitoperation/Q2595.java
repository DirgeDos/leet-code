package com.chestnut.aigc.likou.bitoperation;

import java.util.Arrays;

public class Q2595 {

    public static void main(String[] args) {
        Q2595 q = new Q2595();
        int num = 50;
        int[] x = q.evenOddBit(num);
        System.out.println(Arrays.toString(x));
    }

    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        final int MASK = 0x55555555;
        res[0] = Integer.bitCount(n & MASK);
        res[1] = Integer.bitCount(n & ~MASK);
        return res;
    }
}
