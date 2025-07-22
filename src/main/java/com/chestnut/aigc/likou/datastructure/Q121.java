package com.chestnut.aigc.likou.datastructure;

import java.util.HashMap;

public class Q121 {

    public static void main(String[] args) {
        Q121 q = new Q121();
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};

        int x = q.maxProfit(prices);
        System.out.println(x);
    }


    public int maxProfit(int[] prices) {
        int min = prices[0];
        int result = 0;
        for (int price : prices) {
            result = Math.max(result, price - min);
            min = Math.min(min, price);
        }
        return result;

    }


}
