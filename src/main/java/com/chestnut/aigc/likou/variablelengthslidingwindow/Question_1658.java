package com.chestnut.aigc.likou.variablelengthslidingwindow;


public class Question_1658 {
    public static void main(String[] args) {
        Question_1658 q = new Question_1658();
        int[] nums = new int[]{1,1,4,2,3};
        int xx = q.minOperations(nums, 5);
        System.out.println(xx);
    }

    //有问题
    public int minOperations(int[] nums, int x) {
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        int length = nums.length;

        for (int num : nums) {
            sum += num;
        }
        if (sum - x < 0) {
            return -1;
        }
        sum = 0;
        boolean isNotMin = true;
        for (int i = 0; i < length * 2; i++) {
            sum += nums[i % length];
            while (sum > x) {
                sum -= nums[left % length];
                left++;
            }
            if (sum == x) {
                min = Math.min(min, i - left + 1);
                isNotMin = false;
            }

        }
        if (isNotMin || min > length) {
            min = -1;
        }
        return min;
    }
}
