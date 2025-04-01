package com.chestnut.aigc.likou.variablelengthslidingwindow;


public class Question_633 {
    public static void main(String[] args) {
        Question_633 q = new Question_633();
        int k = 2147482647;
        boolean x = q.judgeSquareSum(k);
        System.out.println(x);
    }

    public boolean judgeSquareSum(int c) {
        if (c == 0 || c == 1) {
            return true;
        }
        long left = 0;
        long right = (long) Math.sqrt(c);
        while (left <= right) {
            if (left * left + right * right == c) {
                return true;
            } else if (left * left + right * right > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }
}
