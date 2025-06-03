package com.chestnut.aigc.likou.monotonestack;


import java.util.Stack;

public class Question_962 {


    public static void main(String[] args) {
        Question_962 q = new Question_962();
        int[] nums = new int[]{9,8,1,0,1,9,4,0,4,1};
        int x = q.maxWidthRamp(nums);
        System.out.println(x);

    }

    public int maxWidthRamp(int[] nums) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}
