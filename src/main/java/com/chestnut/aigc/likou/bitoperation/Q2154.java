package com.chestnut.aigc.likou.bitoperation;


public class Q2154 {

    public static void main(String[] args) {
        Q2154 q = new Q2154();
        int[] nums = new int[]{161,28,640,264,81,561,320,2,61,244,183,108,773,61,976,122,988,2,370,392,488,375,349,432,713,563};
        int original = 61;
        int x = q.findFinalValue(nums, original);
        System.out.println(x);
    }

    public int findFinalValue(int[] nums, int original) {
        //超出范围
        long totalMapBit = 0;
        for (int num : nums) {
            long tempMapBit = Double.valueOf(Math.pow(2, num)).longValue();
            if ((tempMapBit & totalMapBit) != tempMapBit) {
                totalMapBit += Double.valueOf(Math.pow(2, num)).longValue();
            }
        }
        int count = 0;
        while (count < nums.length) {
            long originalMapBit = Double.valueOf(Math.pow(2, original)).longValue();
            if ((originalMapBit & totalMapBit) == originalMapBit) {
                original <<= 1;
            } else {
                break;
            }
            count++;
        }
        return original;
    }
}
