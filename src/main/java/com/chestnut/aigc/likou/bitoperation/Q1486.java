package com.chestnut.aigc.likou.bitoperation;

public class Q1486 {

    public static void main(String[] args) {
        Q1486 q = new Q1486();
        int n = 1;
        int start = 7;
        int x = q.xorOperation(n, start);
        System.out.println(x);
    }


    public int xorOperation(int n, int start) {
        int result = start;
        for (int i = 1; i < n; i++) {
            result ^= start + 2 * i;
        }
        return result;
    }
}
