package com.chestnut.aigc.likou.datastructure;

public class Q2016 {

    public static void main(String[] args) {
        Q2016 q = new Q2016();
        int[] prices = new int[]{9,4,3,2};

        int x = q.maximumDifference(prices);
        System.out.println(x);
    }

    public int maximumDifference(int[] nums) {
        int min = nums[0];
        int result = -1;
        for (int num : nums) {
            if (num > min) {
                result = Math.max(result, num - min);
            }
            min = Math.min(min, num);
        }
        return result;
    }


}
