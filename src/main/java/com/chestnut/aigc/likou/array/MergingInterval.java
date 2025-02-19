package com.chestnut.aigc.likou.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergingInterval {

    public static void main(String[] args) {

        int[][] intervals1 = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] intervals = new int[][]{{1, 4}, {0, 4}};
        int[][] intervals2 = new int[][]{{0, 4}, {1, 4}};
        int[][] merge = merge(intervals);
        System.out.println(Arrays.deepToString(merge));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
        List<int[]> list = new ArrayList<>();
        int[] term = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (term[1] >= intervals[i][0]) {
                term[1] = Math.max(term[1], intervals[i][1]);
            } else {
                list.add(term);
                term = intervals[i];
            }
        }
        list.add(term);
        return list.toArray(new int[list.size()][2]);
    }
}
