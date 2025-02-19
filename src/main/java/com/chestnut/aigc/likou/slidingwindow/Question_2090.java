package com.chestnut.aigc.likou.slidingwindow;

import java.util.Arrays;

public class Question_2090 {
    public static void main(String[] args) {
        Question_2090 q = new Question_2090();
        int[] nums = new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6};
        int[] averages = q.getAverages(nums, 3);
        System.out.println(Arrays.toString(averages));
    }

    public int[] getAverages(int[] nums, int k) {
        long sum = 0;
        int[] averages = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            averages[i] = -1;
            if (i + 1 < 2 * k + 1) {
                continue;
            }
            averages[i - k] = (int)(sum / (2 * k + 1));
            sum -= nums[i - 2 * k];
        }

        return averages;
    }
}
