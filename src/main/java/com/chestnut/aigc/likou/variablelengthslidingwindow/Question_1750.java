package com.chestnut.aigc.likou.variablelengthslidingwindow;

public class Question_1750 {
    public static void main(String[] args) {
        Question_1750 q = new Question_1750();
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
        int xxx = q.minimumLength(s);
        System.out.println(xxx);
    }

    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return right - left + 1;
            } else {
                while (left < right && charArray[left] == charArray[left + 1]) {
                    left++;
                }
                while (left < right && charArray[right] == charArray[right - 1]) {
                    right--;
                }

                left++;
                right--;

            }

        }
        return Math.max(right - left + 1, 0);
    }
}
