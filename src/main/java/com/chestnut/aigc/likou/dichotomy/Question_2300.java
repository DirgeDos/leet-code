package com.chestnut.aigc.likou.dichotomy;


import java.util.Arrays;

public class Question_2300 {
    public static void main(String[] args) {
        Question_2300 q = new Question_2300();
        int[] spells = new int[]{3,1,2};
        int[] potions = new int[]{8,5,8};
        int[] x = q.successfulPairs(spells, potions, 16);
        System.out.println(Arrays.toString(x));
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] res = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            int left = 0;
            int right = potions.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midV = potions[mid];
                long power = (long) midV * spells[i];
                if (power >= success) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            res[i] = potions.length - left;
        }
        return res;
    }


}
