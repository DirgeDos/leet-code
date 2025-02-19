package com.chestnut.aigc.likou.slidingwindow;


import java.util.Arrays;

public class Question_1652 {
    public static void main(String[] args) {
        Question_1652 q = new Question_1652();
        int[] num = new int[]{5,7,1,4};
        int[] xx = q.decrypt(num, 3);
        System.out.println(Arrays.toString(xx));
    }

    public int[] decrypt(int[] code, int k) {
        int length = code.length;
        int[] x = new int[length];
        int windowRightIndex = k > 0 ? k + 1 : length;
        int window = Math.abs(k);
        int sum = 0;
        for (int i = windowRightIndex - window; i < windowRightIndex; i++) {
            sum += code[i];
        }
        for (int i = 0; i < length; i++) {
            x[i] = sum;
            sum -= code[(windowRightIndex - window) % length];
            sum += code[windowRightIndex % length];
            windowRightIndex++;
        }
        return x;
    }
}
