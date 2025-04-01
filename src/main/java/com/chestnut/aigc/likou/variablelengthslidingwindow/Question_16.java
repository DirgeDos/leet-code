package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_16 {
    public static void main(String[] args) {
        Question_16 q = new Question_16();
        int[] nums = new int[]{10,20,30,40,50,60,70,80,90};
        int x = q.threeSumClosest(nums, 1);
        System.out.println(x);
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int close = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == target) {
                    ans = nums[i] + nums[left] + nums[right];
                    return ans;
                }else if (nums[i] + nums[left] + nums[right] < target) {
                    int abs = Math.abs(target - (nums[i] + nums[left] + nums[right]));
                    if (abs < close) {
                        ans = nums[i] + nums[left] + nums[right];
                        close = abs;
                    }
                    left++;
                } else {
                    int abs = Math.abs(target - (nums[i] + nums[left] + nums[right]));
                    if (abs < close) {
                        ans = nums[i] + nums[left] + nums[right];
                        close = abs;
                    }
                    right--;
                }
            }
        }
        return ans;
    }
}
