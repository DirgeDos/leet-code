package com.chestnut.aigc.likou.variablelengthslidingwindow;

public class Question_344 {
    public static void main(String[] args) {
        Question_344 q = new Question_344();
        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        q.reverseString(s);
        System.out.println(s);
    }

    public void reverseString(char[] s) {
        int length = s.length;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left++] = s[right];
            s[right--] = temp;
        }


    }
}
