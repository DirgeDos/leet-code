package com.chestnut.aigc.likou.variablelengthslidingwindow;


public class Question_2730 {
    public static void main(String[] args) {
        Question_2730 q = new Question_2730();
        String s = "0010";
        int xx = q.longestSemiRepetitiveSubstring(s);
        System.out.println(xx);
    }

    public int longestSemiRepetitiveSubstring(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int max = 1;
        int same = 0;
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                same++;
            }
            if (same > 1) {
                left++;
                while (charArray[left] != charArray[left - 1]) {
                    left++;
                }
                same = 1;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
