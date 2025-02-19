package com.chestnut.aigc.likou.indexQ;

import java.util.Arrays;

public class RemoveElement_27 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        RemoveElement_27 r = new RemoveElement_27();
        System.out.println(r.removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
