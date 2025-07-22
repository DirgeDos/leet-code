package com.chestnut.aigc.likou.bitoperation;

import java.util.Arrays;

public class Q1310 {

    public static void main(String[] args) {
        Q1310 q = new Q1310();
        int[] arr = new int[]{16};
        int[][] queries = new int[][]{
                {0, 0},
                {0, 0},
                {0, 0},
        };
        int[] x = q.xorQueries(arr, queries);
        System.out.println(Arrays.toString(x));
    }


    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] orxSums = new int[arr.length + 1];
        for (int i = 1; i < orxSums.length; i++) {
            orxSums[i] = orxSums[i - 1] ^ arr[i - 1];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0] + 1;
            int right = queries[i][1] + 1;
            result[i] = orxSums[left - 1] ^ orxSums[right];
        }
        return result;
    }
}
