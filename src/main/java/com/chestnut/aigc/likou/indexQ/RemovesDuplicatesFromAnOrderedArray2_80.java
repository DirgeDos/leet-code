package com.chestnut.aigc.likou.indexQ;

import java.util.Arrays;

public class RemovesDuplicatesFromAnOrderedArray2_80 {
    public static void main(String[] args) {
        RemovesDuplicatesFromAnOrderedArray2_80 obj = new RemovesDuplicatesFromAnOrderedArray2_80();
        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(obj.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int k = 2;
        int index = 0;
        for (int x : nums) {
            if (index < k || nums[index - k] != x) {
                nums[index] = x;
                index++;
            }
        }
        return index;
    }
}
