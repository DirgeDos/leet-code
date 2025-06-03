package com.chestnut.aigc.likou.monotonestack;


import java.util.ArrayDeque;
import java.util.Stack;

public class Question_1124 {


    public static void main(String[] args) {
        Question_1124 q = new Question_1124();
        int[] nums = new int[]{9, 9, 6, 0, 6, 6, 9};
        int x = q.longestWPI1(nums);
        System.out.println(x);

    }

    public int longestWPI(int[] hours) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int[] arr = new int[hours.length];
        arr[0] = hours[0] > 8 ? 1 : -1;
        stack.push(0);
        for (int i = 1; i < hours.length; i++) {
            arr[i] = arr[i - 1] + (hours[i] > 8 ? 1 : -1);
            if (arr[i] < arr[stack.peek()]) {
                stack.push(i);
            }
        }

        for (int i = hours.length - 1; i >= 0; --i)
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                result = Math.max(result, i - stack.pop());
            }
        return result;
    }

    public int longestWPI1(int[] hours) {
        int n = hours.length, ans = 0;
        int[] s = new int[n + 1]; // 前缀和
        Stack<Integer> st = new Stack<>();
        st.push(0); // s[0]
        for (int j = 1; j <= n; ++j) {
            s[j] = s[j - 1] + (hours[j - 1] > 8 ? 1 : -1);
            if (s[j] < s[st.peek()]) st.push(j); // 感兴趣的 j
        }
        for (int i = n; i > 0; --i)
            while (!st.isEmpty() && s[i] > s[st.peek()])
                ans = Math.max(ans, i - st.pop()); // [栈顶,i) 可能是最长子数组
        return ans;
    }

}
