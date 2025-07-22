package com.chestnut.aigc.likou.datastructure;


import java.util.HashMap;

public class Q1679 {

    public static void main(String[] args) {
        Q1679 q = new Q1679();
        int[] nums = new int[]{1, 1, 1, 2, 3, 4};
        int k = 5;
        int x = q.maxOperations(nums, k);
        System.out.println(x);
    }

    public int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            int x = k - num;
            if (map.containsKey(x)) {
                Integer amount = map.get(x);
                result++;
                if (amount > 1) {
                    map.replace(x, amount - 1);
                } else if (amount == 1) {
                    map.remove(x);
                }
            } else {
                map.merge(num, 1, Integer::sum);
            }
        }
        return result;
    }


}
