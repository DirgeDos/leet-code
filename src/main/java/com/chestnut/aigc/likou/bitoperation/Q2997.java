package com.chestnut.aigc.likou.bitoperation;


public class Q2997 {

    public static void main(String[] args) {
        Q2997 q = new Q2997();
        int[] nums = new int[]{4};
        int k = 7;

        int x = q.minOperations(nums, k);
        System.out.println(x);
    }


    public int minOperations(int[] nums, int k) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return Integer.bitCount(temp ^ k);
    }
}
