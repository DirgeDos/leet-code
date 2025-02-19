package com.chestnut.aigc.likou.indexQ;

public class RotatingArray_189 {
    public static void main(String[] args) {
        RotatingArray_189 r = new RotatingArray_189();

        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        r.rotate(nums, 3);
    }

    public void rotate(int[] nums, int k) {
        k %= nums.length;
        if (k == 0) {
            return;
        }

        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        int frontLen = k;
        for (int i = 0; i < (frontLen) / 2; i++) {
            int tmp = nums[i];
            nums[i] = nums[frontLen - i - 1];
            nums[frontLen - i - 1] = tmp;
        }

        for (int i = 0; i < (nums.length - k) / 2; i++) {
            int temp = nums[i + k ];
            nums[i + k ] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

    }
}
