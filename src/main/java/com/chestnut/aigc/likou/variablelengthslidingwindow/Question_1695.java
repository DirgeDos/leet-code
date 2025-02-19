package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.HashMap;

public class Question_1695 {
    public static void main(String[] args) {
        Question_1695 q = new Question_1695();
        int[] nums = new int[]{4,2,4,5,6};
        int xx = q.totalFruit(nums);
        System.out.println(xx);
    }

    public int totalFruit(int[] nums) {
        int left = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
            while (map.get(num) > 1) {
                sum -= nums[left];
                int i1 = map.get(nums[left]);
                if (i1 - 1 <= 0) {
                    map.remove(nums[left]);
                } else {
                    map.put(nums[left], i1 - 1);
                }
                left++;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
