package com.chestnut.aigc.likou.slidingwindow;

public class MaximumMeanOfSubarrayI_643 {
    public static void main(String[] args) {
        MaximumMeanOfSubarrayI_643 m = new MaximumMeanOfSubarrayI_643();
        int[] nums = new int[]{-1};
        double maxAverage = m.findMaxAverage(nums, 1);
        System.out.println(maxAverage);
    }

    public double findMaxAverage(int[] nums, int k) {
        double max = Integer.MIN_VALUE;
        double sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (i + 1 < k) {
                continue;
            }

            max = Math.max(max, sum / k);
            sum -= nums[i + 1 - k];

        }
        return max;
    }


}
