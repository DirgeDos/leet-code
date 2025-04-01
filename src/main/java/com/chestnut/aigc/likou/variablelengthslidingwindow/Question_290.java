package com.chestnut.aigc.likou.variablelengthslidingwindow;

public class Question_290 {
    public static void main(String[] args) {
        Question_290 q = new Question_290();
        int[] nums = new int[]{2, 3, 1, 2, 4, 3};
        int xx = q.minSubArrayLen(7, nums);
        System.out.println(xx);
    }

    public int minSubArrayLen(int target, int[] nums) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while (sum >= target) {
                min = Math.min(min, i - left + 1);
                sum -= nums[left++];
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
