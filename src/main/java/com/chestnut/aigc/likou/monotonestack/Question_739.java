package com.chestnut.aigc.likou.monotonestack;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class Question_739 {


    public static void main(String[] args) {
        Question_739 q = new Question_739();
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] x = q.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(x));

    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.empty() && temperatures[i] > temperatures[stack.peek()]) {
                Integer j = stack.pop();
                res[j] = i - j;
            }
            stack.push(i);
        }
        return res;
    }

}
