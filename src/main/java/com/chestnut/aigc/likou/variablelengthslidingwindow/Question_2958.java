package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.HashMap;

public class Question_2958 {
    public static void main(String[] args) {
        Question_2958 q = new Question_2958();
        int[] nums = new int[]{1,2,1,2,1,2,1,2};
        int xx = q.maxSubarrayLength(nums, 1);
        System.out.println(xx);
    }

    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            while (map.get(nums[i]) > k) {
                Integer i1 = map.get(nums[left]);
                if (i1 - 1 <= 0) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], i1 - 1);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
