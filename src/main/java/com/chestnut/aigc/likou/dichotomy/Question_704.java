package com.chestnut.aigc.likou.dichotomy;


public class Question_704 {
    public static void main(String[] args) {
        Question_704 q = new Question_704();
        int[] num1 = new int[]{-1, 0, 3, 5, 9, 12};
        int[] num2 = new int[]{2, 3, 4, 5};
        int x = q.search(num1, 9);
        System.out.println(x);
    }

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }
}
