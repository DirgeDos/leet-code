package com.chestnut.aigc.likou.slidingwindow;

import java.util.Arrays;

public class Question_2379 {
    public static void main(String[] args) {
        Question_2379 q = new Question_2379();
        String blocks = "WBBWWBBWBW";
        int xx = q.minimumRecolors(blocks, 7);
        System.out.println(xx);
    }

    public int minimumRecolors(String blocks, int k) {
        char[] charArray = blocks.toCharArray();
        int min = Integer.MAX_VALUE;
        int v = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'W') {
                v++;
            }
            if (i + 1 < k) {
                continue;
            }
            min = Math.min(min, v);
            if (charArray[i - k + 1] == 'W') {
                v--;
            }
        }
        return min;
    }
}
