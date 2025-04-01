package com.chestnut.aigc.likou.monotonestack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Question_503 {
    public static void main(String[] args) {
        Question_503 q = new Question_503();
        int[] nums1 = new int[]{1, 5, 3, 6, 8};
        int[] x = q.nextGreaterElements(nums1);
        System.out.println(Arrays.toString(x));
    }

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int length = nums.length;
        int[] res = new int[length];
        Arrays.fill(res, -1);
        for (int i = 0; i < length * 2; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % length]) {
                res[stack.pop()] = nums[i % length];
            }
            if (i < length) {
                stack.push(i % length);
            }
        }
        return res;
    }
}
