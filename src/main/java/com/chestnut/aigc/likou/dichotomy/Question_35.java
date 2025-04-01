package com.chestnut.aigc.likou.dichotomy;

import java.util.Arrays;

public class Question_35 {
    public static void main(String[] args) {
        Question_35 q = new Question_35();
        int[] num1 = new int[]{1, 3, 5, 6};
        int[] num2 = new int[]{2, 3, 4, 5};
        int x = q.searchInsert(num1, 4);
        System.out.println(x);
    }

    public int searchInsert(int[] nums, int target) {
        return dichotomy(nums, target);
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
