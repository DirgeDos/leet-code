package com.chestnut.aigc.likou.datastructure;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q2815 {

    public static void main(String[] args) {
        Q2815 q = new Q2815();
        int[] nums = new int[]{51, 71, 17, 24, 42};

        int x = q.maxSum(nums);
        System.out.println(x);
    }

    public int maxSum(int[] nums) {
        int[] maxV = new int[10];
        Arrays.fill(maxV, Integer.MIN_VALUE);
        int result = -1;
        for (int num : nums) {
            int maxNum = -1;
            for (int i = num; i > 0; i /= 10) {
                maxNum = Math.max(i % 10, maxNum);
            }
            result = Math.max(result, num + maxV[maxNum]);
            maxV[maxNum] = Math.max(maxV[maxNum], num);
        }
        return result;
    }


}
