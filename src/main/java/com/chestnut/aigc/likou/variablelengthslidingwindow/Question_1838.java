package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.Arrays;

public class Question_1838 {
    public static void main(String[] args) {
        Question_1838 q = new Question_1838();
        int[] nums = new int[]{1, 1, 1, 1, 1, 1};
        int xx = q.maxFrequency(nums, 1);
        System.out.println(xx);
    }

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int max = 1;
        int left = 0;
        long sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += (long) (nums[i] - nums[i - 1]) * (i - left);
            while (sum > k) {
                sum -= nums[i] - nums[left];
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
