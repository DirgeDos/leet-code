package com.chestnut.aigc.likou.bitoperation;

public class Q231 {

    public static void main(String[] args) {
        Q231 q = new Q231();
        int num = 12;
        boolean x = q.isPowerOfTwo(num);
        System.out.println(x);
    }

    public boolean isPowerOfTwo(int n) {
        if (Integer.bitCount(n) != 1) {
            return false;
        }
        int mostSignificantBit = 32 - Integer.numberOfLeadingZeros(n);
        int x = Double.valueOf(Math.pow(2, mostSignificantBit - 1)).intValue();
        return x == n;
    }
}
