package com.chestnut.aigc.likou.variablelengthslidingwindow;


public class Question_1208 {
    public static void main(String[] args) {
        Question_1208 q = new Question_1208();
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int xx = q.equalSubstring(s, t, maxCost);
        System.out.println(xx);
    }

    public int equalSubstring(String s, String t, int maxCost) {
        int[] differenceValue = new int[s.length()];
        char[] firstStr = s.toCharArray();
        char[] secondStr = t.toCharArray();
        for (int i = 0; i < firstStr.length; i++) {
            differenceValue[i] = Math.abs(firstStr[i] - secondStr[i]);
        }

        int left = 0;
        int cosSum = 0;
        int max = 0;
        for (int i = 0; i < differenceValue.length; i++) {
            cosSum += differenceValue[i];
            while (cosSum > maxCost) {
                cosSum -= differenceValue[left];
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
