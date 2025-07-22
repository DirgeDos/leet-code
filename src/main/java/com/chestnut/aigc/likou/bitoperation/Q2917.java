package com.chestnut.aigc.likou.bitoperation;

public class Q2917 {

    public static void main(String[] args) {
        Q2917 q = new Q2917();
        int[] nums = new int[]{7, 12, 9, 8, 9, 15};
        int i = q.findKOr(nums, 4);
        System.out.println(i);
    }

    public int findKOr(int[] nums, int k) {
        int result = 0;

        for (int i = 0; i < 31; i++) {
            int kNum = 0;
            int bitSite = Double.valueOf(Math.pow(2, i)).intValue();
            for (int num : nums) {
                if ((num & bitSite) == bitSite) {
                    kNum++;
                }
            }
            if (kNum >= k) {
                result += bitSite;
            }

        }
        return result;
    }
}
