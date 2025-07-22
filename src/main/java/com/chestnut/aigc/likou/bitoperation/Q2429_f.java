package com.chestnut.aigc.likou.bitoperation;


public class Q2429_f {

    /**
     * 二进制最低位的1怎么去掉
     * x & (~x + 1)
     */
    public static void main(String[] args) {
        Q2429_f q = new Q2429_f();
        int num1 = 8;
        int num2 = 75;

        int x = q.minimizeXor(num1, num2);
        System.out.println(x);
    }


    public int minimizeXor(int num1, int num2) {
        System.out.println("num1 = " + Integer.toBinaryString(num1));
        System.out.println("num2 = " + Integer.toBinaryString(num2));
        int x1 = Integer.bitCount(num1);
        int x2 = Integer.bitCount(num2);
        int result = num1;

        if (x2 > x1) {
            int lowestOneBit = Integer.lowestOneBit(num1);
            for (int i = 0; i < x2 - x1; i++) {
                result += 1 << lowestOneBit;
            }
            return result;
        }
        for (int i = 0; i < x2; i++) {
            int bitSite = 32 - Integer.numberOfLeadingZeros(result);
            result ^= 1 << (bitSite - 1);
        }
        return result ^ num1;

    }
}
