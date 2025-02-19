package com.chestnut.aigc.likou.variablelengthslidingwindow;

import java.util.HashMap;

public class Question_3 {
    public static void main(String[] args) {
        Question_3 q = new Question_3();
        String s = "abcabcbb";
        int xx = q.lengthOfLongestSubstring(s);
        System.out.println(xx);
    }

    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        char[] charArray = s.toCharArray();
        int max = 0;
        int left = 0;
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
            while (map.get(charArray[i]) > 1) {
                if (map.get(charArray[left]) - 1 <= 0) {
                    map.remove(charArray[left]);
                } else {
                    map.put(charArray[left], map.get(charArray[left]) - 1);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
