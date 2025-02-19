package com.chestnut.aigc.likou.variablelengthslidingwindow;

import java.util.HashMap;

public class Question_3090 {
    public static void main(String[] args) {
        Question_3090 q = new Question_3090();
        String s = "dcfdddccb";
        int xx = q.maximumLengthSubstring(s);
        System.out.println(xx);
    }

    public int maximumLengthSubstring(String s) {
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        int[] temp = new int[26];
        int left = 0;
        int value = (int) 'a';
        for (int i = 0; i < charArray.length; i++) {
            int cu = (int) charArray[i];
            temp[cu - value] += 1;
            while (temp[cu - value] > 2) {
                int i1 = temp[(int) charArray[left] - value];
                if (i1 - 1 >= 0) {
                    temp[(int) charArray[left] - value] -= 1;
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
