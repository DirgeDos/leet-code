package com.chestnut.aigc.likou.monotonestack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Question_901 {
    private Stack<Integer> stack;
    private int[] array;
    private int[] resArray;
    private int index;

    public static void main(String[] args) {
        Question_901 stockSpanner = new Question_901();
        stockSpanner.next(100); // 返回 1
        stockSpanner.next(80);  // 返回 1
        stockSpanner.next(60);  // 返回 1
        stockSpanner.next(70);  // 返回 2
        stockSpanner.next(60);  // 返回 1
        stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
        stockSpanner.next(85);  // 返回 6
    }

    public Question_901() {
        stack = new Stack<>();
        array = new int[10005];
        resArray = new int[10005];
        index = 0;
    }

    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && price >= array[stack.peek()]) {
            Integer index = stack.pop();
            res += resArray[index];
        }
        stack.push(index);
        array[index] = price;
        resArray[index] = res;
        index++;
        System.out.println(res);
        return res;
    }
}
