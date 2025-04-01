package com.chestnut.aigc.likou.dichotomy;

import java.util.Arrays;

public class Question_34 {
    public static void main(String[] args) {
        Question_34 q = new Question_34();
        int[] num1 = new int[]{5, 7, 7, 8, 8, 10};
        int[] num2 = new int[]{2, 3, 4, 5};
        int[] x = q.searchRange(num1, 8);
        System.out.println(Arrays.toString(x));
    }

    public int[] searchRange(int[] nums, int target) {
        int start = dichotomy(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        int end = dichotomy(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private int dichotomy(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] >= target) {
                right = mid - 1;
            }
        }
        return left;
    }
}
