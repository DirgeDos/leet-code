package com.chestnut.aigc.likou.variablelengthslidingwindow;

import java.util.*;


public class Question_1471 {
    public static void main(String[] args) {
        Question_1471 q = new Question_1471();
        int[] nums = new int[]{6,7,11,7,6,8};
        int k = 5;
        int[] closestElements = q.getStrongest(nums, k);
        System.out.println(Arrays.toString(closestElements));
    }

    public int[] getStrongest(int[] arr, int k) {
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int mid = (arr.length - 1) / 2;
        int[] res = new int[k];
        int index = 0;
        while (left <= right && index < k) {
            if (Math.abs(arr[left] - arr[mid]) > Math.abs(arr[right] - arr[mid])) {
                res[index++] = arr[left++];
            } else if (arr[left] == arr[mid] && arr[left] > arr[right]) {
                res[index++] = arr[left++];
            } else {
                res[index++] = arr[right--];
            }
        }
        return res;
    }
}
