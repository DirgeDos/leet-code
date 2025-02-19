package com.chestnut.aigc.likou.doublepointer;

public class InversionString {

    public static void main(String[] args) {
        char[] c = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        reverseString(c);
        System.out.println(c);
    }

    public static void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
