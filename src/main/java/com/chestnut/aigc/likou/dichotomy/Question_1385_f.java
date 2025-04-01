package com.chestnut.aigc.likou.dichotomy;


import java.util.Arrays;

public class Question_1385_f {
    public static void main(String[] args) {
        Question_1385_f q = new Question_1385_f();
        int[] arr1 = new int[]{-3, 10, 2, 8, 0, 10};
        int[] arr2 = new int[]{-9, -1, -4, -9, -8};
        int x = q.findTheDistanceValue(arr1, arr2, 9);
        System.out.println(x);
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int count = 0;
        for (int i = 0; i < arr1.length; i++) {
            int left = 0;
            int right = arr2.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midVal = arr2[mid];
                int diffVal = Math.abs(arr1[i] - midVal);
                if (diffVal > d) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                    count++;
                    break;
                }
            }
        }
        return arr1.length - count;
    }


}
