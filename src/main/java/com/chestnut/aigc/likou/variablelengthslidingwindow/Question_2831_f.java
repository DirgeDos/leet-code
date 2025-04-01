package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.ArrayList;
import java.util.List;

public class Question_2831_f {
    public static void main(String[] args) {
        Question_2831_f q = new Question_2831_f();
        int[] nums = new int[]{5, 6, 7, 8, 9};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(3);
        int xx = q.longestEqualSubarray(list, 3);
        System.out.println(xx);
    }

    public int longestEqualSubarray(List<Integer> nums, int k) {
        return 0;
    }
}
