package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.Arrays;

public class Question_611_f {
    public static void main(String[] args) {
        Question_611_f q = new Question_611_f();
        int[] nums = new int[]{4, 2, 3, 4};
        int x = q.triangleNumber(nums);
        System.out.println(x);
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = nums.length - 1; i >= 1; i--) {
            int left = 0;
            int right = i - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                }
                if (right == i) {
                    right--;
                }
                boolean f = nums[i] + nums[left] > nums[right];
                boolean s = nums[i] + nums[right] > nums[left];
                boolean t = nums[left] + nums[right] > nums[i];
                if (f || s || t) {
                    count++;
                }
//                if (nums[left] == nums[right]) {
//                    count++;
//                }
                if (t) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
