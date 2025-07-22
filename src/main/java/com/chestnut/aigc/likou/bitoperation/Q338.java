package com.chestnut.aigc.likou.bitoperation;

import java.util.Arrays;

public class Q338 {

    public static void main(String[] args) {
        Q338 q = new Q338();
        int num = 8;
        int[] x = q.countBits(num);
        System.out.println(Arrays.toString(x));
    }

    public int[] countBits(int n) {
        int[] result = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            result[i] = result[i >> 1] + (i & 1);
        }
        return result;
    }
}
