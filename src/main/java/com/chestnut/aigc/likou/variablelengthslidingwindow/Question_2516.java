package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.Arrays;

public class Question_2516 {
    public static void main(String[] args) {
        Question_2516 q = new Question_2516();
        String s = "aabaaaacaabc";
        int xx = q.takeCharacters(s, 2);
        System.out.println(xx);
    }

    public int takeCharacters(String s, int k) {
        int[] counts = new int[3];
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            counts[charArray[i] - 'a']++;
        }
        if (counts[0] < k || counts[1] < k || counts[2] < k) {
            return -1;
        }

        int max = 0;
        int left = 0;
        for (int i = 0; i < charArray.length; i++) {
            counts[charArray[i] - 'a']--;
            while (counts[charArray[i] - 'a'] < k) {
                counts[charArray[left] - 'a']++;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return charArray.length - max;
    }
}
