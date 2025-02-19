package com.chestnut.aigc.likou.doublepointer;

public class ArraySplit1 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,4,3,2};
        System.out.println(arrayPairSum(nums));
    }
    //TODO:题有问题
    public static int arrayPairSum(int[] nums) {
        int maxSum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
