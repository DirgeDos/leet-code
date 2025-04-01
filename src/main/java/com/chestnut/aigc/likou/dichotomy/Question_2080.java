package com.chestnut.aigc.likou.dichotomy;


import java.util.Arrays;

public class Question_2080 {
    private final int[] array;

    public Question_2080(int[] arr) {
        array = arr;
    }

    public int query(int left, int right, int value) {
        int endIndex = index(left, right, value + 1);
        if (endIndex < 1) {
            return 0;
        }
        int startIndex = index(left, right, value);
        return endIndex - startIndex;
    }

    private int index(int left, int right, int value) {
        int[] newArrays = Arrays.copyOfRange(array, left, right + 1);
        Arrays.sort(newArrays);
        int newLeft = 0;
        int newRight = newArrays.length - 1;
        while (newLeft <= newRight) {
            int mid = newLeft + (newRight - newLeft) / 2;
            int midVal = newArrays[mid];
            if (midVal >= value) {
                newRight = mid - 1;
            } else {
                newLeft = mid + 1;
            }
        }
        return newLeft;
    }

    public static void main(String[] args) {
        int[] a = new int[]{12, 33, 4, 56, 22, 2, 34, 33, 22, 12, 34, 56};
        Question_2080 q = new Question_2080(a);
        int query = q.query(1, 2, 4);
        System.out.println(query);
    }

}
