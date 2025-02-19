package com.chestnut.aigc.likou.stackandqueue;

import java.util.LinkedList;
import java.util.Stack;

public class VerifyTheOrderOfBookRetrieval {
    public static void main(String[] args) {
        int[] putIn = new int[]{2,1,0};
        int[] takeOut = new int[]{1,2,0};
        System.out.println(validateBookSequences(putIn, takeOut));
    }

    public static boolean validateBookSequences(int[] putIn, int[] takeOut) {
        Stack<Integer> stack = new Stack<>();
        int takeOutIndex = 0;
        for (int j : putIn) {
            stack.push(j);

            if (!stack.isEmpty() && stack.lastElement() == takeOut[takeOutIndex]) {
                takeOutIndex++;
                stack.pop();
                while (!stack.isEmpty()) {
                    if (stack.lastElement() == takeOut[takeOutIndex]) {
                        stack.pop();
                        takeOutIndex++;
                    } else {
                        break;
                    }
                }
            }

        }
        return stack.isEmpty();
    }

}
