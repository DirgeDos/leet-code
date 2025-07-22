package com.chestnut.aigc.likou.bitoperation;

public class Q1009 {

    public static void main(String[] args) {
        Q1009 q = new Q1009();
        int num = 5;
        int i = q.bitwiseComplement(num);
        System.out.println(i);
    }

    public int bitwiseComplement(int n) {
        int len = 32 - Integer.numberOfLeadingZeros(n);
        int mask = (1 << len) - 1;
        return n == 0 ? 1 : n ^ mask;
    }
}
