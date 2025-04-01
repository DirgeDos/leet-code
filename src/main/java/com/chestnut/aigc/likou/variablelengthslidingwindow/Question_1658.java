package com.chestnut.aigc.likou.variablelengthslidingwindow;


public class Question_1658 {
    public static void main(String[] args) {
        Question_1658 q = new Question_1658();
        int[] nums = new int[]{5, 6, 7, 8, 9};
        int xx = q.minOperations(nums, 4);
        System.out.println(xx);
    }

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum - x < 0) {
            return -1;
        }

        int left = 0;
        int max = 0;
        boolean isNotEquality = true;
        for (int i = 0; i < nums.length; i++) {
            sum -= nums[i];
            while (sum < x) {
                sum += nums[left++];
            }
            if (sum == x) {
                max = Math.max(max, i - left + 1);
                isNotEquality = false;
            }
        }
        if (isNotEquality) {
            return -1;
        }

        return nums.length - max;
    }
}
