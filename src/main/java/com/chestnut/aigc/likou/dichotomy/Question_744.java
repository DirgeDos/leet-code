package com.chestnut.aigc.likou.dichotomy;


public class Question_744 {
    public static void main(String[] args) {
        Question_744 q = new Question_744();
        char[] letters = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        char[] letters1 = new char[]{'e', 'e', 'g', 'g'};
        char[] letters2 = new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        char x = q.nextGreatestLetter(letters, 'y');
        System.out.println(x);
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0;
        int right = letters.length - 1;
        if (letters[right] < target) {
            return letters[left];
        }
        char min = 123;
        while (left <= right) {
            int mid = (left + right) / 2;
            char midL = letters[mid];
            if (midL == target) {
                left = mid + 1;
                /*if (mid != letters.length - 1) {
                    return letters[mid + 1];
                } else {
                    return letters[0];
                }*/
            }
            if (midL < target) {
                left = mid + 1;
            }
            if (midL > target) {
                right = mid - 1;
                if (midL - 'a' < min - 'a') {
                    min = midL;
                }
            }
        }
        return min == 123 ? letters[0] : min;
    }
}
