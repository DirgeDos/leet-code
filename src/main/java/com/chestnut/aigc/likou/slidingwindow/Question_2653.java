package com.chestnut.aigc.likou.slidingwindow;


import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Question_2653 {
    public static void main(String[] args) {
        Question_2653 q = new Question_2653();
        int[] nums = new int[]{-50, 14};
        int k = 2;
        int x = 2;
        int[] xx = q.getSubarrayBeauty2(nums, k, x);
        System.out.println(Arrays.toString(xx));
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        //超出时间
        int length = nums.length;
        int newLen = length + 1 - k;
        int[] res = new int[newLen];
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int j = x;
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (i + 1 < k) {
                continue;
            }
            AtomicInteger times = new AtomicInteger(0);
            List<Integer> key = map.keySet().stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
            int i2 = x - 1;
            int i3 = 1000;
            for (Integer integer : key) {
                Integer v = map.get(integer);
                i2 = i2 - v;
                if (i2 < 0) {
                    i3 = integer;
                    break;
                }
            }

            if (i3 > 0) {
                res[count++] = 0;
            } else {
                for (Integer integer : key) {
                    Integer i1 = map.get(integer);
                    j -= i1;
                    if (j <= 0) {
                        res[count++] = integer;
                        break;
                    }
                }
            }

            Integer v1 = map.get(nums[i + 1 - k]) - 1;

            if (v1 <= 0) {
                map.remove(nums[i + 1 - k]);
            } else {
                map.put(nums[i + 1 - k], map.get(nums[i + 1 - k]) - 1);
            }
        }
        return res;
    }

    public int[] getSubarrayBeauty2(int[] nums, int k, int x) {
        final int BIAS = 50;
        int[] cnt = new int[BIAS * 2 + 1];
        for (int i = 0; i < k - 1; i++) { // 先往窗口内添加 k-1 个数
            cnt[nums[i] + BIAS]++;
        }

        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for (int i = k - 1; i < n; i++) {
            cnt[nums[i] + BIAS]++; // 进入窗口（保证窗口有恰好 k 个数）
            int left = x;
            for (int j = 0; j < BIAS; j++) { // 暴力枚举负数范围 [-50,-1]
                left -= cnt[j];
                if (left <= 0) { // 找到美丽值
                    ans[i - k + 1] = j - BIAS;
                    break;
                }
            }
            cnt[nums[i - k + 1] + BIAS]--; // 离开窗口
        }
        return ans;
    }
}
