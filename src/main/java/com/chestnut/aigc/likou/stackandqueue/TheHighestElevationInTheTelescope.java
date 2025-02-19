package com.chestnut.aigc.likou.stackandqueue;

import java.util.*;

public class TheHighestElevationInTheTelescope {
    public static void main(String[] args) {
        int[] heights = new int[]{};
        System.out.println(Arrays.toString(maxAltitude(heights, 3)));
    }

    public static int[] maxAltitude(int[] heights, int limit) {
        if (heights.length == 0) {
            return new int[]{};
        }

        Queue<Integer> queue = new LinkedList<>();
        List<Integer> maxList = new ArrayList<>();

        int len = Math.min(heights.length, limit);
        for (int i = 0; i < len; i++) {
            queue.add(heights[i]);
        }
        Integer max = queue.stream().max(Integer::compare).orElse(0);
        maxList.add(max);
        int group = heights.length - limit;
        for (int i = 0; i < group; i++) {
            queue.poll();
            queue.add(heights[i + limit]);
            Integer cMax = queue.stream().max(Integer::compare).orElse(0);
            maxList.add(cMax);
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }
}
