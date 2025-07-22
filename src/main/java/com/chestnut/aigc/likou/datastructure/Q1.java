package com.chestnut.aigc.likou.datastructure;

import java.util.Arrays;
import java.util.HashMap;

public class Q1 {

    public static void main(String[] args) {
        Q1 q = new Q1();
        int[] nums = new int[]{2,7,11,15};
        int target = 9;
        int[] x = q.twoSum(nums, target);
        System.out.println(Arrays.toString(x));
    }


    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int i1 = target - nums[i];
            if (!map.containsKey(i1)) {
                map.put(nums[i], i);
            } else {
                return new int[]{map.get(i1), i};
            }
        }
        return null;
    }
}
