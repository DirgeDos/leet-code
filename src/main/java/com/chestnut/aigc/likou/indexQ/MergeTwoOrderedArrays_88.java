package com.chestnut.aigc.likou.indexQ;

import java.util.Arrays;

public class MergeTwoOrderedArrays_88 {
    public static void main(String[] args) {
//        int[] nums1 = new int[]{0};
        int[] nums1 = new int[]{2, 0};
//        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{1};
//        int[] nums2 = new int[]{2, 5, 6};
        MergeTwoOrderedArrays_88 obj = new MergeTwoOrderedArrays_88();

        obj.merge(nums1, 1, nums2, 1);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = m, j = 0; i < nums1.length; i++, j++) {
            nums1[i] = nums2[j];
        }
        Arrays.sort(nums1);
    }
}
