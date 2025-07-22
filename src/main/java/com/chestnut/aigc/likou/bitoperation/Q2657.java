package com.chestnut.aigc.likou.bitoperation;

import java.util.Arrays;

public class Q2657 {

    public static void main(String[] args) {
        Q2657 q = new Q2657();
        int[] numsA = new int[]{2, 3, 1};
        int[] numsB = new int[]{3, 1, 2};
        int[] x = q.findThePrefixCommonArray(numsA, numsB);
        System.out.println(Arrays.toString(x));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            long aNum = 0;
            long bNum = 0;
            for (int j = 0; j <= i; j++) {
                aNum += Double.valueOf(Math.pow(2, A[j])).longValue();
                bNum += Double.valueOf(Math.pow(2, B[j])).longValue();
            }
            long unite = aNum & bNum;
            result[i] = Long.bitCount(unite);
        }
        return result;
    }
}
