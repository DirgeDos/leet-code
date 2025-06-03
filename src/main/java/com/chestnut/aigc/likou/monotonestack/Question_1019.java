package com.chestnut.aigc.likou.monotonestack;


import java.util.Arrays;
import java.util.Stack;

public class Question_1019 {


    public static void main(String[] args) {
        Question_1019 q = new Question_1019();
        ListNode v2 = new ListNode(2);
        ListNode v7 = new ListNode(7);
        ListNode v4 = new ListNode(4);
        ListNode v3 = new ListNode(3);
        ListNode v5 = new ListNode(5);
        v2.next = v7;
        v7.next = v4;
        v4.next = v3;
        v3.next = v5;
        int[] x = q.nextLargerNodes(v2);
        System.out.println(Arrays.toString(x));

    }

    public int[] nextLargerNodes(ListNode head) {
        Stack<Integer> stackV = new Stack<>();
        Stack<Integer> stackI = new Stack<>();
        ListNode root = head;
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        int index = 0;
        int[] res = new int[len];
        while (root != null) {
            while (!stackV.isEmpty() && stackV.peek() < root.val) {
                res[stackI.pop()] = root.val;
                stackV.pop();
            }
            stackV.push(root.val);
            stackI.push(index);
            index++;
            root = root.next;
        }

        return res;
    }

}
