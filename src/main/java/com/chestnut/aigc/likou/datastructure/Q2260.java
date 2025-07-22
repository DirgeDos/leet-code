package com.chestnut.aigc.likou.datastructure;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Q2260 {

    public static void main(String[] args) {
        Q2260 q = new Q2260();
        int[] cards = new int[]{95, 11, 8, 65, 5, 86, 30, 27, 30, 73, 15, 91, 30, 7, 37, 26, 55, 76, 60, 43, 36, 85, 47, 96, 6};

        int x = q.minimumCardPickup(cards);
        System.out.println(x);
    }

    public int minimumCardPickup(int[] cards) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int result = 100001;
        for (int i = 0; i < cards.length; i++) {
            List<Integer> list;
            if (!map.containsKey(cards[i])) {
                list = new ArrayList<>();
            } else {
                list = map.get(cards[i]);
                for (Integer integer : list) {
                    result = Math.min(result, Math.abs(integer - i) + 1);
                }
            }
            list.add(i);
            map.put(cards[i], list);
        }
        return result == 100001 ? -1 : result;
    }




}
