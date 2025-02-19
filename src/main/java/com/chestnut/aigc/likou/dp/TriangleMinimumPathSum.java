package com.chestnut.aigc.likou.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangleMinimumPathSum {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(2));
        list.add(Arrays.asList(3, 4));
        list.add(Arrays.asList(6, 5, 7));
        list.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(minimumTotal(list));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 1) {
            return triangle.get(0).get(0);
        }
        int min = 0;
        int[] pathIndex = new int[triangle.size()];
        pathIndex[0] = 0;
        for (int i = 1; i < triangle.size(); i++) {
            int listMin = Integer.MAX_VALUE;
            for (int j = 0; j < triangle.get(i).size(); j++) {
                if (j > 0 && j < triangle.get(i).size() - 1) {
                    triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i - 1).get(j - 1), triangle.get(i - 1).get(j)));
                } else {
                    if (j == 0) {
                        triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(0));
                    } else {
                        triangle.get(i).set(j, triangle.get(i).get(j) + triangle.get(i - 1).get(j - 1));
                    }
                }
                listMin = Math.min(listMin, triangle.get(i).get(j));
            }
            pathIndex[i] = triangle.get(i).indexOf(listMin);
            min = listMin;
        }
        System.out.println(Arrays.toString(pathIndex));
        return min;
    }
}
