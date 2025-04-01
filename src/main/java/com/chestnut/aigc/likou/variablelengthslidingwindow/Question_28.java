package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question_28 {
    public static void main(String[] args) {
        Question_28 q = new Question_28();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = q.threeSum(nums);
        System.out.println(lists);
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (right == i) {
                    right--;
                    continue;
                }
                if (-nums[i] == nums[left] + nums[right]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    lists.add(list);
                    for (left++; left < right && nums[left] == nums[left - 1]; left++) ;
                    for (right--; left < right && nums[right] == nums[right + 1]; right--) ;
                } else if (-nums[i] < nums[left] + nums[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return lists;
    }
}
