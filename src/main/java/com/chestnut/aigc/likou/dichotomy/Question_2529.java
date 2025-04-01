package com.chestnut.aigc.likou.dichotomy;


public class Question_2529 {
    public static void main(String[] args) {
        Question_2529 q = new Question_2529();
        int[] nums = new int[]{-2, -1, -1, 1, 2, 3};
        int x = q.maximumCount(nums);
        System.out.println(x);
    }

    public int maximumCount(int[] nums) {
        int fIndex = dichotomy(nums, 0);
        int neg = fIndex + 1;

        int sIndex = dichotomy(nums, 1) + 1;
        int pos = nums.length - sIndex;
        return Math.max(neg, pos);
    }

    private int dichotomy(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midNum = nums[mid];
            if (midNum >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
