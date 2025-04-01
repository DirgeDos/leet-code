package com.chestnut.aigc.likou.monotonestack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Question_496 {
    public static void main(String[] args) {
        Question_496 q = new Question_496();
        int[] nums1 = new int[]{2,4};
        int[] nums2 = new int[]{1,2,3,4};
        int[] x = q.nextGreaterElement(nums1,nums2);
        System.out.println(Arrays.toString(x));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Map<Integer, Integer> idx = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            idx.put(nums1[i], i);
        }
        Arrays.fill(nums1, -1);
        Stack<Integer> st = new Stack<>();
        for (int x : nums2) {
            while (!st.isEmpty() && x > st.peek()) {
                nums1[idx.get(st.pop())] = x;
            }
            if (idx.containsKey(x)) {
                st.push(x);
            }
        }
        return nums1;
    }
}
