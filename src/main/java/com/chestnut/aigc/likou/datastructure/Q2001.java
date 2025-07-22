package com.chestnut.aigc.likou.datastructure;

import java.util.*;

public class Q2001 {

    public static void main(String[] args) {
        Q2001 q = new Q2001();
        int[][] nums = new int[][]{
                {4, 8},
                {3, 6},
                {10, 20},
                {15, 30},
        };
        long x = q.interchangeableRectangles(nums);
        System.out.println(x);
    }


    public long interchangeableRectangles(int[][] rectangles) {
        HashMap<Double, Integer> map = new HashMap<>();
        long result = 0;
        for (int[] rectangle : rectangles) {
            double width = rectangle[0];
            double height = rectangle[1];
            double specificValue = width / height;
            if (map.containsKey(specificValue)) {
                result += map.get(specificValue);
                map.put(specificValue, map.get(specificValue) + 1);
            } else {
                map.put(specificValue, 1);
            }
        }
        return result;
    }
}
