package com.chestnut.aigc.likou.datastructure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q219 {

    public static void main(String[] args) {
        Q219 q = new Q219();
        int[] nums = new int[]{1, 2, 3, 1};
        int k = 3;

        boolean x = q.containsNearbyDuplicate(nums, k);
        System.out.println(x);
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(nums[i], list);
            } else {
                List<Integer> list = map.get(nums[i]);
                for (Integer integer : list) {
                    if (Math.abs(i - integer) <= k) {
                        return true;
                    }
                }
                list.add(i);
                map.put(nums[i], list);
            }
        }
        return result;
    }


}
