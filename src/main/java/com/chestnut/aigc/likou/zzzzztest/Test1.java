package com.chestnut.aigc.likou.zzzzztest;

public class Test1 {
    public static void main(String[] args) {
        String userAccount = "1868858159406657535";
        int x = userAccount.charAt(userAccount.length() - 1);
        int y = x & 1;
        System.out.println(y);
    }
}
