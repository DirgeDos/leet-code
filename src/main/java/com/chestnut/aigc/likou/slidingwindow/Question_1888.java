package com.chestnut.aigc.likou.slidingwindow;


import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Question_1888 {
    public static void main(String[] args) {
        Question_1888 q = new Question_1888();
        String s = "1110";
        int xx = q.minFlips(s);
        System.out.println(xx);
    }

    public int minFlips(String s) {
        String s2 = s+s;
        char[] charArray = s2.toCharArray();
        int changeNum = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
            if (i + 1 < 2) {
                continue;
            }
            if (map.size() < 2) {
                changeNum++;
                map.put(charArray[i], map.get(charArray[i]) - 1);
                if (charArray[i] == '0') {
                    charArray[i] = '1';
                    map.put('1', map.getOrDefault('1', 0) + 1);
                } else {
                    charArray[i] = '0';
                    map.put('0', map.getOrDefault('0', 0) + 1);
                }
            }

            int i1 = map.get(charArray[i - 1]) - 1;
            if (i1 <= 0) {
                map.remove(charArray[i - 1]);
            } else {
                map.put(charArray[i - 1], map.get(charArray[i - 1]) - 1);
            }
        }
        return changeNum;
    }
}
