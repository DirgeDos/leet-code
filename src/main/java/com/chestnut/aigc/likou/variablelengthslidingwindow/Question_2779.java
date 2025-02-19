package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.Arrays;

public class Question_2779 {
    public static void main(String[] args) {
        Question_2779 q = new Question_2779();
        int[] nums = new int[]{4, 6, 1, 2};
        int xx = q.maximumBeauty(nums, 2);
        System.out.println(xx);
    }

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] - k > nums[left] + k) {
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
