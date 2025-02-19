package com.chestnut.aigc.likou.slidingwindow;

public class FixedLengthSlidingWindow_1456 {
    public static void main(String[] args) {
        String s = "abciiidef";
        FixedLengthSlidingWindow_1456 slidingWindow = new FixedLengthSlidingWindow_1456();
        int i = slidingWindow.maxVowels(s, 3);
        System.out.println(i);
    }

    public int maxVowels(String s, int k) {
        char[] charArray = s.toLowerCase().toCharArray();
        int v = 0;
        int max = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u') {
                v++;
            }
            if (i + 1 < k) {
                continue;
            }
            max = Math.max(max, v);
            if (charArray[i + 1 - k] == 'a' || charArray[i + 1 - k] == 'e' || charArray[i + 1 - k] == 'i' || charArray[i + 1 - k] == 'o' || charArray[i + 1 - k] == 'u') {
                v--;
            }


        }
        return max;
    }
}
