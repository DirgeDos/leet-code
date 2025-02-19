package com.chestnut.aigc.likou.slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Question_2841 {
    public static void main(String[] args) {
        Question_2841 q = new Question_2841();
        Integer[] num = new Integer[]{2, 5, 6, 2, 1, 2, 7, 5, 8, 5};
        List<Integer> collect = Arrays.stream(num).collect(Collectors.toList());
        long xx = q.maxSum(collect, 4, 4);
        System.out.println(xx);
    }

    public long maxSum(List<Integer> nums, int m, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long max = 0;
        long sum = 0;
        for (int i = 0; i < nums.size(); i++) {
            map.put(nums.get(i), map.getOrDefault(nums.get(i), 0) + 1);
            sum += nums.get(i);
            if (i + 1 < k) {
                continue;
            }
            if (map.size() >= m) {
                max = Math.max(max, sum);
            }
            Integer i1 = nums.get(i + 1 - k);
            sum -= i1;
            int i2 = map.getOrDefault(i1, 0) - 1;

            if (i2 <= 0) {
                map.remove(nums.get(i + 1 - k));
            } else {
                map.put(i1, i2);
            }


        }
        return max;
    }
}
