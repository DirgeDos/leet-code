package com.chestnut.aigc.likou.bitoperation;

public class Q3226 {

    public static void main(String[] args) {
        Q3226 q = new Q3226();
        int n = 14;
        int k = 13;
        int x = q.minChanges(n, k);
        System.out.println(x);
    }

    public int minChanges(int n, int k) {
        if ((k & n) != k) {
            return -1;
        }
        int x = k ^ n;
        return Integer.bitCount(x);
    }
}
