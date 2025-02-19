package com.chestnut.aigc.likou.slidingwindow;


import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Question_1297 {
    public static void main(String[] args) {
        Question_1297 q = new Question_1297();
        String s = "aababcaab";
        int maxLetters = 2;
        int minSize = 3;
        int maxSize = 4;
        int xx = q.maxFreq(s, maxLetters, minSize, maxSize);
        System.out.println(xx);
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        char[] charArray = s.toCharArray();
        int length = charArray.length;

        AtomicInteger max = new AtomicInteger();
        HashMap<String, Integer> subStrMap = new HashMap<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++) {
            map.put(charArray[i], map.getOrDefault(charArray[i], 0) + 1);
            if (i + 1 < minSize) {
                continue;
            }
            if (map.size() <= maxLetters) {
                String substring = s.substring(i + 1 - minSize, i + 1);
                subStrMap.put(substring, subStrMap.getOrDefault(substring, 0) + 1);
            }
            int i1 = map.get(charArray[i + 1 - minSize]) - 1;
            if (i1 <= 0) {
                map.remove(charArray[i + 1 - minSize]);
            } else {
                map.put(charArray[i + 1 - minSize], i1);
            }
        }
        subStrMap.forEach((x, y) -> {
            max.set(Math.max(y, max.get()));
        });
        return max.get();
    }
}
