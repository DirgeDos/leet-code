package com.chestnut.aigc.likou.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Question_2461 {
    public static void main(String[] args) {
        Question_2461 q = new Question_2461();
        int[] num = new int[]{1,5,4,2,9,9,9};
        long xx = q.maximumSubarraySum(num, 3);
        System.out.println(xx);
    }

    public long maximumSubarraySum(int[] nums, int k) {
        long sum = 0;
        long max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            sum += nums[i];
            if (i + 1 < k) {
                continue;
            }
            if (map.size() >= k) {
                max = Math.max(max, sum);
            }
            sum -= nums[i + 1 - k];
            int i1 = map.getOrDefault(nums[i + 1 - k], 0) - 1;
            if (i1 <= 0) {
                map.remove(nums[i + 1 - k]);
            } else {
                map.put(nums[i + 1 - k], i1);
            }
        }
        return max;
    }
}
