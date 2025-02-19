package com.chestnut.aigc.likou.slidingwindow;

import java.util.HashMap;

public class Question_1461 {
    public static void main(String[] args) {
        Question_1461 q = new Question_1461();
        String s = "00110110";
        boolean xx = q.hasAllCodes(s, 2);
        System.out.println(xx);
    }

    public boolean hasAllCodes(String s, int k) {
        int length = s.length();
        if (length == 1) {
            return true;
        }
        if (length <= k) {
            return false;
        }
        HashMap<String, Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(charArray[i]);
            if (i + 1 < k) {
                continue;
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
            sb.deleteCharAt(0);
        }
        return map.size() == Math.pow(2, k);
    }
}
