package com.chestnut.aigc.likou.bitoperation;

import java.util.Arrays;

public class Q2433 {

    public static void main(String[] args) {
        Q2433 q = new Q2433();
        int[] pref = new int[]{5, 2, 0, 3, 1};
        int[] x = q.findArray(pref);
        System.out.println(Arrays.toString(x));
    }


    public int[] findArray(int[] pref) {
        int[] result = new int[pref.length];
        result[0] = pref[0];
        for (int i = 1; i < pref.length; i++) {
            result[i] = pref[i] ^ pref[i - 1];
        }
        return result;
    }
}
