package com.chestnut.aigc.likou.variablelengthslidingwindow;


public class Question_1004 {
    public static void main(String[] args) {
        Question_1004 q = new Question_1004();
        int[] nums = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        int xx = q.longestOnes(nums, 3);
        System.out.println(xx);
    }

    public int longestOnes(int[] nums, int k) {
        int[] arr = new int[2];
        int max = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;
            while (arr[0] > k) {
                arr[nums[left]]--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
