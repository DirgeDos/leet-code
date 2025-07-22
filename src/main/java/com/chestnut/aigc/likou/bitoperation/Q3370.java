package com.chestnut.aigc.likou.bitoperation;

public class Q3370 {

    public static void main(String[] args) {
        Q3370 q = new Q3370();
        int n = 8;
        int x = q.smallestNumber(n);
        System.out.println(x);
    }

    public int smallestNumber(int n) {
        int numberOfOne = 32 - Integer.numberOfLeadingZeros(n);
        int fullOne = 1 << numberOfOne;
        return fullOne - 1;
    }
}
