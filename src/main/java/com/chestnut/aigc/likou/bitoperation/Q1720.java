package com.chestnut.aigc.likou.bitoperation;

import java.util.Arrays;

public class Q1720 {

    public static void main(String[] args) {
        Q1720 q = new Q1720();
        int[] nums = new int[]{6,2,7,3};
        int first = 4;
        int[] x = q.decode(nums, first);
        System.out.println(Arrays.toString(x));
    }


    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 0; i < encoded.length; i++) {
            result[i + 1] = result[i] ^ encoded[i];
        }
        return result;
    }
}
