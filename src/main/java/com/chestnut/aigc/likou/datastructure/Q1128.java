package com.chestnut.aigc.likou.datastructure;

import java.util.HashMap;

public class Q1128 {

    public static void main(String[] args) {
        Q1128 q = new Q1128();
        int[][] nums = new int[][]{
                {2, 1},
                {1, 2},
                {1, 1},
                {1, 2},
                {2, 2},
        };
        int[][] points = {
                {2, 1}, {5, 4}, {3, 7}, {6, 2}, {4, 4}, {1, 8}, {9, 6}, {5, 3},
                {7, 4}, {1, 9}, {1, 1}, {6, 6}, {9, 6}, {1, 3}, {9, 7}, {4, 7},
                {5, 1}, {6, 5}, {1, 6}, {6, 1}, {1, 8}, {7, 2}, {2, 4}, {1, 6},
                {3, 1}, {3, 9}, {3, 7}, {9, 1}, {1, 9}, {8, 9}
        };
        long x = q.numEquivDominoPairs(points);
        System.out.println(x);
    }


    //可以使用二维数组做
    public int numEquivDominoPairs(int[][] dominoes) {
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        int result = 0;
        for (int[] domino : dominoes) {
            int x = domino[0];
            int y = domino[1];
            if (x > y) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            if (map.containsKey(x)) {
                if (map.get(x).containsKey(y)) {
                    result += map.get(x).get(y);
                    map.get(x).put(y, map.get(x).get(y) + 1);
                } else {
                    map.get(x).put(y, 1);
                }
            } else {
                HashMap<Integer, Integer> tmp = new HashMap<>();
                tmp.put(y, 1);
                map.put(x, tmp);
            }
        }
        return result;
    }


}
