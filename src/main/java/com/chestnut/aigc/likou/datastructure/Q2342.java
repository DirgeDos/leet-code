package com.chestnut.aigc.likou.datastructure;


import java.util.Arrays;
import java.util.HashMap;

public class Q2342 {

    public static void main(String[] args) {
        Q2342 q = new Q2342();
        int[] nums = new int[]{18, 43, 36, 13, 7};

        int x = q.maximumSum(nums);
        System.out.println(x);
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = -1;
        for (int num : nums) {
            int numSum = 0;
            for (int j = num; j > 0; j /= 10) {
                numSum += j % 10;
            }
            Integer orDefault = map.getOrDefault(numSum, Integer.MIN_VALUE);
            map.put(numSum, Math.max(num, orDefault));
            result = Math.max(result, num + orDefault);
        }
        return result;
    }


}
