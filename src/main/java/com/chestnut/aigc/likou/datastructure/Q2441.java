package com.chestnut.aigc.likou.datastructure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Q2441 {

    public static void main(String[] args) {
        Q2441 q = new Q2441();
        int[] nums = new int[]{-1, 2, -3, 3};
        int x = q.findMaxK(nums);
        System.out.println(x);
    }


    public int findMaxK(int[] nums) {
        int result = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(-num)) {
                set.add(num);
            } else {
                result = Math.max(result, Math.abs(num));
            }
        }
        return result;
    }
}
