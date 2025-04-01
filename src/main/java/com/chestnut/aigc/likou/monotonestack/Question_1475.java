package com.chestnut.aigc.likou.monotonestack;


import java.util.Arrays;
import java.util.Stack;

public class Question_1475 {


    public static void main(String[] args) {
        Question_1475 q = new Question_1475();
        int[] prices = new int[]{10,1,1,6};
        int[] x = q.finalPrices(prices);
        System.out.println(Arrays.toString(x));

    }

    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.empty() && prices[i] <= prices[stack.peek()]) {
                Integer index = stack.pop();
                prices[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }



}
