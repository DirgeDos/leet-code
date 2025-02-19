package com.chestnut.aigc.likou.slidingwindow;


import java.util.Arrays;
import java.util.HashMap;

public class Question_2134 {
    public static void main(String[] args) {
        Question_2134 q = new Question_2134();
        int[] num = new int[]{0, 1, 0, 1, 1, 0, 0};
        int xx = q.minSwaps(num);
        System.out.println(xx);
    }

    public int minSwaps(int[] nums) {
        int window = 0;
        for (int num : nums) {
            window += num;
        }

        int max = 0;
        int count = 0;
        for (int i = 0; i < nums.length + window; i++) {
            if (nums[i % nums.length] == 1) {
                count++;
            }
            if (i + 1 < window) {
                continue;
            }
            max = Math.max(max, count);
            if (nums[(i + 1 - window) % nums.length] == 1) {
                count--;
            }
        }
        return window - max;
    }
}
