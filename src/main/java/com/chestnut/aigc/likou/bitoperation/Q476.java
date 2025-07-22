package com.chestnut.aigc.likou.bitoperation;

public class Q476 {

    public static void main(String[] args) {
        Q476 q = new Q476();
        int num = 5;
        int i = q.findComplement(num);
        System.out.println(i);
    }

    public int findComplement(int num) {
        int len = 32 - Integer.numberOfLeadingZeros(num);
        int mask = (1 << len) - 1;
        return num ^ mask;
    }
}
