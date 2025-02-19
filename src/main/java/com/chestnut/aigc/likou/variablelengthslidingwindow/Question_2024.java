package com.chestnut.aigc.likou.variablelengthslidingwindow;


public class Question_2024 {
    public static void main(String[] args) {
        Question_2024 q = new Question_2024();
        String answerKey = "TTFTTFTT";
        int xx = q.maxConsecutiveAnswers(answerKey, 1);
        System.out.println(xx);
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        int[] arr = new int[2];
        int left = 0;
        int max = 0;
        char[] charArray = answerKey.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'T') {
                arr[1]++;
            } else if (charArray[i] == 'F') {
                arr[0]++;
            }

            while (arr[0] > k && arr[1] > k) {
                int i1 = charArray[left] == 'T' ? 1 : 0;
                arr[i1]--;
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
