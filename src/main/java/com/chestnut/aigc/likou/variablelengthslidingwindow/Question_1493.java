package com.chestnut.aigc.likou.variablelengthslidingwindow;


public class Question_1493 {
    public static void main(String[] args) {
        Question_1493 q = new Question_1493();
        int[] nums = new int[]{0,1,1,1,0,1,1,0,1};
        int xx = q.longestSubarray(nums);
        System.out.println(xx);
    }

    public int longestSubarray(int[] nums) {
        int[] zeroOne = new int[2];
        int left = 0;
        int max = 0;
        boolean notZero = true;
        for (int num : nums) {
            if (num == 0) {
                notZero = false;
            }
            zeroOne[num]++;

            while (zeroOne[0] > 1) {
                if (zeroOne[nums[left]] - 1 >= 0) {
                    zeroOne[nums[left]]--;
                }
                left++;
            }
            max = Math.max(max, zeroOne[1]);
        }
        if (notZero) {
            max -= 1;
        }
        return max;
    }
}
