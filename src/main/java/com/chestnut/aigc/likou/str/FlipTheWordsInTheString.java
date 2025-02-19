package com.chestnut.aigc.likou.str;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FlipTheWordsInTheString {
    public static void main(String[] args) {
        String s = "the sky is blue";
        String s1 = reverseWords(s);
        System.out.println(s1);
    }

    public static String reverseWords(String s) {
        String trim = s.trim();
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        char[] charArray = trim.toCharArray();
        for (char c : charArray) {
            if (!Character.isWhitespace(c)) {
                sb.append(c);
            } else {
                if (!sb.toString().trim().isEmpty()) {
                    words.add(sb.toString());
                }
                sb = new StringBuilder();
            }
        }
        words.add(sb.toString());
        Collections.reverse(words);
        return String.join(" ", words);
    }
}
