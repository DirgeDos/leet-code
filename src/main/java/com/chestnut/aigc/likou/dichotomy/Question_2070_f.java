package com.chestnut.aigc.likou.dichotomy;


import java.util.Arrays;
import java.util.Comparator;

public class Question_2070_f {


    //超时
    public static void main(String[] args) {
        Question_2070_f q = new Question_2070_f();
        int[][] items = new int[][]{{1, 2}, {3, 2}, {2, 4}, {5, 6}, {3, 5}};
        int[][] items1 = new int[][]{{10, 1000}};
        int[] queries = new int[]{1, 2, 3, 4, 5, 6};
        int[] queries1 = new int[]{5};
        int[] x = q.maximumBeauty(items1, queries1);
        System.out.println(Arrays.toString(x));
    }

    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, Comparator.comparingInt(a -> a[0]));
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int i1 = dichotomyMoney(items, queries[i] + 1);
            res[i] = i1;
        }
        return res;
    }

    private int dichotomyMoney(int[][] items, int target) {
        int left = 0, right = items.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int midMoney = items[mid][0];
            if (midMoney >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int i = dichotomyValue(items, left);

        return i;
    }

    private int dichotomyValue(int[][] items, int right) {
        if (right < 1) {
            return 0;
        }
        int[] temp = new int[right];
        for (int i = 0; i < right; i++) {
            temp[i] = items[i][1];
        }
        Arrays.sort(temp);
        return temp[temp.length - 1];
    }
}
