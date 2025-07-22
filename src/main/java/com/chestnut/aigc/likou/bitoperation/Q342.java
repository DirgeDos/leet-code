package com.chestnut.aigc.likou.bitoperation;

public class Q342 {

    public static void main(String[] args) {
        Q342 q = new Q342();
        int num = 16;
        boolean x = q.isPowerOfFour(num);
        System.out.println(x);
    }

    public boolean isPowerOfFour(int n) {
        if (Integer.bitCount(n) != 1) {
            return false;
        }
        int mostSignificantBit = 32 - Integer.numberOfLeadingZeros(n);
        if ((mostSignificantBit - 1) % 2 != 0) {
            return false;
        }
        int x = Double.valueOf(Math.pow(2, mostSignificantBit - 1)).intValue();
        return x == n;
    }
}
