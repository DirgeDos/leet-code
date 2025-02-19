package com.chestnut.aigc.likou.indexQ;

import java.util.Arrays;

public class RemovesDuplicatesFromAnOrderedArray1_26 {
    public static void main(String[] args) {
        RemovesDuplicatesFromAnOrderedArray1_26 obj = new RemovesDuplicatesFromAnOrderedArray1_26();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(obj.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
