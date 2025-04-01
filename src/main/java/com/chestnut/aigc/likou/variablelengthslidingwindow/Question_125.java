package com.chestnut.aigc.likou.variablelengthslidingwindow;

public class Question_125 {
    public static void main(String[] args) {
        Question_125 q = new Question_125();
        String s = "A man, a plan, a canal: Panama";
        boolean xxx = q.isPalindrome(s);
        System.out.println(xxx);
    }

    public boolean isPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        while (left <= right) {
            if (!Character.isLetterOrDigit(charArray[left])) {
                left++;
            } else if (!Character.isLetterOrDigit(charArray[right])) {
                right--;
            } else if (Character.toLowerCase(charArray[left++]) != Character.toLowerCase(charArray[right--])) {
                return false;
            }
        }
        return true;
    }
}
