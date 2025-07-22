package com.chestnut.aigc.likou.bitoperation;

public class Q191 {

    public static void main(String[] args) {
        Q191 q = new Q191();
        int num = 2147483645;
        int x = q.hammingWeight(num);
        System.out.println(x);
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
