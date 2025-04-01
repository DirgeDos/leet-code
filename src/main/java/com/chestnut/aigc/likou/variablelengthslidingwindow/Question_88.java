package com.chestnut.aigc.likou.variablelengthslidingwindow;

import java.util.Arrays;
import java.util.HashMap;

public class Question_88 {
    public static void main(String[] args) {
        Question_88 q = new Question_88();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        int m = 3;
        int n = 3;
        q.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = m - 1;
        int y = n - 1;
        int z = m + n - 1;
        while (y >= 0) {
            if (x >= 0 && nums1[x] > nums2[y]) {
                nums1[z] = nums1[x];
                x--;
            } else {
                nums1[z] = nums2[y];
                y--;
            }
            z--;
        }
    }
}
