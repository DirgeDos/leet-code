package com.chestnut.aigc.likou.str;

public class LongestReturnStringOfText {

    public static void main(String[] args) {
        String str = "abbbvvcabac";
        String s = longestPalindrome(str);
        System.out.println(s);
    }

    public static String longestPalindrome(String s) {
        StringBuilder t = new StringBuilder("$#");
        for (int i = 0; i < s.length(); ++i) {
            t.append(s.charAt(i));
            t.append("#");
        }
        t.append("@");
        // Process t
        int[] p = new int[t.length()];

        int mx = 0, id = 0, resLen = 0, resCenter = 0;
        for (int i = 1; i < t.length() - 1; ++i) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;
            while (((i - p[i]) >= 0) && ((i + p[i]) < t.length() - 1) && (t.charAt(i + p[i]) == t.charAt(i - p[i])))
                ++p[i];
            if (mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if (resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen - 1);
    }
}
