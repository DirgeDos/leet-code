package com.chestnut.aigc.likou.dichotomy;


import java.util.Arrays;

public class Question_2563_f {

    public static void main(String[] args) {
        Question_2563_f q = new Question_2563_f();
        int[] nums = new int[]{0, 1, 7, 4, 4, 5};
        long l = q.countFairPairs(nums, 3, 6);
        System.out.println(l);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int start = lower - nums[i];
            int end = upper - nums[i];
            int leftIndex = dichotomy(nums, i, start);
            int rightIndex = dichotomy(nums, i, end + 1);
            count += rightIndex - leftIndex;
        }
        return count;
    }

    private int dichotomy(int[] nums, int right, int target) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            int midVal = nums[mid];
            if (midVal >= target) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

}
