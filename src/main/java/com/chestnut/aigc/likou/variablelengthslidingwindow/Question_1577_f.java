package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.Arrays;

public class Question_1577_f {
    public static void main(String[] args) {
        Question_1577_f q = new Question_1577_f();
        int[] num1 = new int[]{1, 1};
        int[] num2 = new int[]{1, 1, 1};
        int x = q.numTriplets(num1, num2);
        System.out.println(x);
    }

    public int numTriplets(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int left = 0;
            int right = nums2.length - 1;
            while (left < right) {
                long m1 = (long) nums1[i] * (long) nums1[i];
                long m2 = (long) nums2[left] * (long) nums2[right];
                if (m1 == m2) {
                    if (nums2[left] == nums2[right]) {
                        count += right - left + 1;
                    }
                    count++;
                    left++;
                } else if (m1 < m2) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            int left = 0;
            int right = nums1.length - 1;
            while (left < right) {
                long m2 = (long) nums2[i] * (long) nums2[i];
                long m1 = (long) nums1[left] * (long) nums1[right];
                if (m1 == m2) {
                    count++;
                    left++;
                } else if (m1 < m2) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return count;
    }
}
