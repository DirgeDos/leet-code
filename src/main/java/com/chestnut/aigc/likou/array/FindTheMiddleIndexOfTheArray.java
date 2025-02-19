package com.chestnut.aigc.likou.array;

public class FindTheMiddleIndexOfTheArray {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -1, 0, 0, -1, -1};
        int theMiddleIndexOfTheArray = findTheMiddleIndexOfTheArray(nums);
        System.out.println(theMiddleIndexOfTheArray);
    }

    /**
     * 寻找数组的中间索引(取最左一个)
     * @param nums 数组
     * @return
     */
    public static int findTheMiddleIndexOfTheArray(int[] nums) {
        /**
         * 给你一个整数数组nums ，请计算数组的 中心下标 。
         * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
         * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
         * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
         */
        int sum = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
        }
        int leftSum = 0;
        int midIndex = 0;
        while (midIndex <= nums.length - 1) {
            if (midIndex != 0) {
                leftSum += nums[midIndex - 1];
                sum -= nums[midIndex];
            }
            if (sum == leftSum) {
                return midIndex;
            }
            midIndex++;
        }
        return -1;
    }
}
