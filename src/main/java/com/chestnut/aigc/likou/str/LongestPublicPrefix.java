package com.chestnut.aigc.likou.str;

import java.util.Arrays;
import java.util.Comparator;

public class LongestPublicPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"reflower","flow","flight"};
        String s = longestCommonPrefix(strs);
        System.out.println(s);
    }

    public static String longestCommonPrefix(String[] strs) {
        String[] sortedArray = Arrays.stream(strs)
                .sorted(Comparator.comparingInt(String::length))
                .toArray(String[]::new);

        char[] charArray = sortedArray[0].toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            for (int i1 = 1; i1 < sortedArray.length; i1++) {
                if (charArray[i] != sortedArray[i1].toCharArray()[i]) {
                    return sortedArray[0].substring(0, i);
                }
            }
        }
        return sortedArray[0];
    }
}
