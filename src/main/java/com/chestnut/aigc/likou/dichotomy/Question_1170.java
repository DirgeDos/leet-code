package com.chestnut.aigc.likou.dichotomy;


import java.util.Arrays;

public class Question_1170 {
    public static void main(String[] args) {
        Question_1170 q = new Question_1170();
        String[] queries = new String[]{"bbb", "cc"};
        String[] words = new String[]{"a", "aa", "aaa", "aaaa"};
        int[] x = q.numSmallerByFrequency(queries, words);
        System.out.println(Arrays.toString(x));
    }

    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] result = new int[queries.length];

        int[] queriesNum = new int[queries.length];
        int[] wordsNum = new int[words.length];

        for (int i = 0; i < queries.length; i++) {
            int minFr = minF(queries[i]);
            queriesNum[i] = minFr;
        }
        for (int i = 0; i < words.length; i++) {
            int minFr = minF(words[i]);
            wordsNum[i] = minFr;
        }

        Arrays.sort(wordsNum);
        for (int i = 0; i < queriesNum.length; i++) {
            int left = 0;
            int right = wordsNum.length - 1;
            int max = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int midVal = wordsNum[mid];
                if (midVal > queriesNum[i]) {
                    max = wordsNum.length - mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            result[i] = max;
        }
        return result;

    }

    private int minF(String word) {
        int[] arr = new int[26];
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            arr[c - 'a']++;
        }

        for (int i : arr) {
            if (i > 0) {
                return i;
            }
        }
        return 0;
    }

}
