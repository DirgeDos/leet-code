package com.chestnut.aigc.likou.datastructure;

import java.util.*;

public class Q1512 {

    public static void main(String[] args) {
        Q1512 q = new Q1512();
        int[] nums = new int[]{1, 2, 3};
        int x = q.numIdenticalPairs(nums);
        System.out.println(x);
    }


    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                result += map.get(num);
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        return result;
    }
}
