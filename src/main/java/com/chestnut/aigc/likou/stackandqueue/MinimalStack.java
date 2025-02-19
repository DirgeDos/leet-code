package com.chestnut.aigc.likou.stackandqueue;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Stack;

public class MinimalStack {
    LinkedList<Integer> list1;
    LinkedList<Integer> min;
    Stack<Integer> stack1;

    public static void main(String[] args) {
        MinimalStack minimalStack = new MinimalStack();
        minimalStack.push(0);
        minimalStack.push(1);
        minimalStack.push(0);
        int min = minimalStack.getMin();
        minimalStack.pop();
        System.out.println(min);
    }

    public MinimalStack() {
        list1 = new LinkedList<>();
        min = new LinkedList<>();
    }

    public void push(int x) {
        list1.addLast(x);
        if (min.isEmpty()) {
            min.addLast(x);
        } else {
            Integer last = min.getLast();
            if (last >= x) {
                min.addLast(x);
            }
        }
    }

    public void pop() {
        Integer i = list1.removeLast();
        if (!min.isEmpty()) {
            if (Objects.equals(min.getLast(), i)) {
                min.removeLast();
            }
        }
    }

    public int top() {
        return list1.getLast();
    }

    public int getMin() {
        return min.isEmpty() ? -1 : min.getLast();
    }
}
