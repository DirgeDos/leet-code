package com.chestnut.aigc.likou.variablelengthslidingwindow;

import java.util.Arrays;

public class Question_977 {
    public static void main(String[] args) {
        Question_977 q = new Question_977();
        int[] nums = new int[]{-7,-3,2,3,11};

        int[] into = q.sortedSquares(nums);
        System.out.println(Arrays.toString(into));
    }

    public int[] sortedSquares(int[] nums) {
        int left = 0, right = nums.length - 1;
        int x = nums.length - 1;
        int[] res = new int[nums.length];
        while (left <= right) {
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                res[x] = nums[left] * nums[left];
                left++;
            } else {
                res[x] = nums[right] * nums[right];
                right--;
            }
            x--;
        }
        return res;
    }
}
