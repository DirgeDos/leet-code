package com.chestnut.aigc.likou.slidingwindow;


public class Question_1423 {
    public static void main(String[] args) {
        Question_1423 q = new Question_1423();
        int[] num = new int[]{1, 2, 3, 4, 5, 6, 1};
        long xx = q.maxScore(num, 3);
        System.out.println(xx);
    }

    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += cardPoints[i];
        }
        if (cardPoints.length == k) {
            return sum;
        }
        int max = sum;
        for (int i = 0; i < k; i++) {
            sum -= cardPoints[k - 1 - i];
            sum += cardPoints[cardPoints.length - 1 - i];
            max = Math.max(max, sum);
        }
        return max;
    }
}
