package com.chestnut.aigc.likou.monotonestack;

import java.util.Stack;

public class Question_853 {
    private Stack<Integer> stack;
    private int[] array;
    private int[] resArray;
    private int index;

    public static void main(String[] args) {
        Question_853 q = new Question_853();
        int target = 10;
        int[] position = new int[]{0, 4, 2};
        int[] speed = new int[]{2, 1, 3};
        int x = q.carFleet(target, position, speed);
        System.out.println(x);

    }

    public int carFleet(int target, int[] position, int[] speed) {
        double[] time = new double[target];
        for (int i = 0; i < position.length; i++) {
            time[position[i]] = (target - position[i]) / (double) speed[i];
        }

        Stack<Double> stack = new Stack<>();
        for (int i = 0; i < target; i++) {
            if (time[i] > 0) {
                while (!stack.isEmpty() && time[i] >= stack.peek()) {
                    stack.pop();
                }
                stack.push(time[i]);
            }
        }
        return stack.size();
    }


}
