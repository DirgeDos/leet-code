package com.chestnut.aigc.likou.bitoperation;

public class Q416 {

    public static void main(String[] args) {
        Q416 q = new Q416();
        int x = 1;
        int y = 4;
        int i = q.hammingDistance(x, y);
        System.out.println(i);
    }

    public int hammingDistance(int x, int y) {
        int i = x ^ y;
        return Integer.bitCount(i);
    }
}
