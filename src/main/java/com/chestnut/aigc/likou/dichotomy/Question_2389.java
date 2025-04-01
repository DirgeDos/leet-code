package com.chestnut.aigc.likou.dichotomy;


import java.util.Arrays;

public class Question_2389 {
    public static void main(String[] args) {
        Question_2389 q = new Question_2389();
        int[] nums = new int[]{2,3,4,5};
        int[] queries = new int[]{1};
        int[] x = q.answerQueries(nums, queries);
        System.out.println(Arrays.toString(x));
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] res = new int[queries.length];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }

        for (int i = 0; i < queries.length; i++) {
            int left = 0;
            int right = nums.length - 1;
            int max = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midVal = nums[mid];
                if (midVal <= queries[i]) {
                    max = Math.max(max, mid);
                    res[i] = max+1;
                    left = mid + 1;
                } else {
                    right = mid - 1;

                }
            }
        }
        return res;
    }


}
