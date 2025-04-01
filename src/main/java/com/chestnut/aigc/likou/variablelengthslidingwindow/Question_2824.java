package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.Arrays;
import java.util.List;

public class Question_2824 {
    public static void main(String[] args) {
        Question_2824 q = new Question_2824();
        List<Integer> nums = Arrays.asList(-1, 1, 2, 3, 1);
        int x = q.countPairs(nums, 2);
        System.out.println(x);
    }

    public int countPairs(List<Integer> nums, int target) {
        Integer[] array = nums.toArray(new Integer[0]);
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        int count = 0;
        while (left < right) {
            if (array[left] + array[right] < target) {
                count += right - left;
                left++;
            } else {
                right--;
            }
        }
        return count;
    }
}
