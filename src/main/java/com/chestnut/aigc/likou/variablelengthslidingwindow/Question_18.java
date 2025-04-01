package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_18 {
    public static void main(String[] args) {
        Question_18 q = new Question_18();
        int[] nums = new int[]{1000000000, 1000000000, 1000000000, 1000000000};
        List<List<Integer>> lists = q.fourSum(nums, -294967296);
        System.out.println(lists);
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long)nums[i] + (long)nums[j] + (long)nums[left] + (long)nums[right];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        lists.add(list);
                        for (left++; left < right && nums[left] == nums[left - 1]; left++) ;
                        for (right--; left < right && nums[right] == nums[right + 1]; right--) ;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
                int x = j + 1;
                for (; x < nums.length && nums[x] == nums[x - 1]; x++) ;
                if (j + 1 != x) {
                    j = x - 1;
                }
            }
            int y = i + 1;
            for (; y < nums.length && nums[y] == nums[y - 1]; y++) ;
            if (i + 1 != y) {
                i = y - 1;
            }
        }
        return lists;
    }
}
