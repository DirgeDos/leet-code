package com.chestnut.aigc.likou.slidingwindow;

public class Question_1343 {
    public static void main(String[] args) {
        Question_1343 q = new Question_1343();
        int[] arr = new int[]{2,2,2,2,5,5,5,8};
        int i = q.numOfSubArrays(arr, 3, 4);
        System.out.println(i);
    }

    public int numOfSubArrays(int[] arr, int k, int threshold) {
        double sum = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (i + 1 >= k && sum / k >= threshold) {
                max++;
            }
            if (i + 1 < k) {
                continue;
            }
            sum -= arr[i + 1 - k];

        }
        return max;
    }
}
