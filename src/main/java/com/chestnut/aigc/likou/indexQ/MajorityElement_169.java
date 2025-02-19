package com.chestnut.aigc.likou.indexQ;

import java.util.HashMap;
import java.util.Set;

public class MajorityElement_169 {
    public static void main(String[] args) {
        MajorityElement_169 m = new MajorityElement_169();
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(m.majorityElement1(nums));
    }

    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        Integer maxK = 0;
        Integer maxV = 0;
        Set<Integer> integers = map.keySet();
        for (Integer k : integers) {
            if (map.get(k) > maxV) {
                maxK = k;
                maxV = map.get(k);
            }
        }
        return maxK;
    }
    //使用摩尔投票法
    public int majorityElement1(int[] nums) {
        int max = nums[0];
        int v = 1;
        for (int i = 1; i < nums.length; i++) {
            if (max == nums[i]) {
                v++;
            }else {
                v--;
            }
            if (v == 0) {
                max = nums[i];
                v = 1;
            }
        }
        return max;
    }
}
