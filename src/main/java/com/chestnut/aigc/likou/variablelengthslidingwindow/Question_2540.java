package com.chestnut.aigc.likou.variablelengthslidingwindow;

public class Question_2540 {
    public static void main(String[] args) {
        Question_2540 q = new Question_2540();
        int[] num1 = new int[]{1, 2, 3, 6};
        int[] num2 = new int[]{2, 3, 4, 5};
        int x = q.getCommon(num1, num2);
        System.out.println(x);
    }

    public int getCommon(int[] nums1, int[] nums2) {
//        int min = Integer.MAX_VALUE;
        int first = 0;
        int second = 0;
        while (first < nums1.length && second < nums2.length) {
            if (nums1[first] < nums2[second]) {
                first++;
            } else if (nums1[first] > nums2[second]) {
                second++;
            } else {
//                min = Math.min(min, nums1[first]);
//                for (first++; first < nums1.length && nums1[first] == nums1[first - 1]; first++) ;
//                for (second++; second < nums2.length && nums2[second] == nums2[second - 1]; second++) ;
                return nums1[first];
            }
        }
        return -1;
    }
}
