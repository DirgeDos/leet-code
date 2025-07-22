package com.chestnut.aigc.likou.bitoperation;

public class Q2220 {

    public static void main(String[] args) {
        Q2220 q = new Q2220();
        int start = 1;
        int goal = 4;
        int i = q.minBitFlips(start, goal);
        System.out.println(i);
    }

    public int minBitFlips(int start, int goal) {
        int x = start ^ goal;
        return Integer.bitCount(x);
    }
}
