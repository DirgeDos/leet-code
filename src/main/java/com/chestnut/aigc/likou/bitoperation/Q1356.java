package com.chestnut.aigc.likou.bitoperation;

import java.util.Arrays;
import java.util.Comparator;

public class Q1356 {

    public static void main(String[] args) {
        Q1356 q = new Q1356();
        int[] n = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int[] x = q.sortByBits(n);
        System.out.println(Arrays.toString(x));
    }

    public int[] sortByBits(int[] arr) {
        return Arrays.stream(arr).boxed().sorted(Comparator.comparingInt(Integer::bitCount).thenComparing(x -> x)).mapToInt(x -> x).toArray();
    }
}
