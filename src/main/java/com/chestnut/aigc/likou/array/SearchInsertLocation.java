package com.chestnut.aigc.likou.array;

public class SearchInsertLocation {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6};
        int i = searchInsert(arr, 2);
        System.out.println(i);
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
                if (left > nums.length - 1) {
                    return nums.length;
                }
            }
            if (nums[mid] > target) {
                right = mid - 1;
                if (right < 0) {
                    return 0;
                }
            }

        }
        return left;
    }
}
