package com.chestnut.aigc.likou.variablelengthslidingwindow;

import java.util.*;


public class Question_658_f {
    public static void main(String[] args) {
        Question_658_f q = new Question_658_f();
        int[] nums = new int[]{0,0,1,2,3,3,4,7,7,8};
        int k = 3;
        int x = 5;
        List<Integer> closestElements = q.findClosestElements(nums, k, x);
        System.out.println(closestElements);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Integer[] nums = new Integer[k];
        int index = 0;
        int left = 0;
        int right = arr.length - 1;
        //todo:有问题
        while (index < k) {
            int a = Math.abs(arr[left] - x);
            int b = Math.abs(arr[right] - x);
            if (a < b) {
                nums[index] = arr[left++];
            } else if (a == b && arr[left] < arr[right]) {
                nums[index] = arr[left];
                left++;
            } else {
                nums[index] = arr[right--];
            }
            index++;
        }
       /* int[] result = new int[k];
        left = 0;
        right = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {

        }*/
        ArrayList<Integer> arrayList = new ArrayList<>(nums.length);
        Collections.addAll(arrayList, nums);
        arrayList.sort(Comparator.naturalOrder());
        return arrayList;
    }
}
