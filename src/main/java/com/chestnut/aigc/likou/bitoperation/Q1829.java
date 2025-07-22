package com.chestnut.aigc.likou.bitoperation;


import java.util.Arrays;

public class Q1829 {

    public static void main(String[] args) {
        Q1829 q = new Q1829();
        int[] nums = new int[]{2,3,4,7};
        int maximumBit = 3;

        int[] x = q.getMaximumXor(nums, maximumBit);
        System.out.println(Arrays.toString(x));
    }


    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int[] xorSum = new int[nums.length + 1];
        for (int i = 1; i < xorSum.length; i++) {
            xorSum[i] = xorSum[i - 1] ^ nums[i - 1];
        }
        int max = (1 << maximumBit) - 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = xorSum[xorSum.length - 1 - i] ^ max;
        }
        return result;
    }
}
