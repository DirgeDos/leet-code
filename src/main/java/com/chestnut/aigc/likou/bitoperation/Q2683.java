package com.chestnut.aigc.likou.bitoperation;


import java.util.Arrays;

public class Q2683 {

    public static void main(String[] args) {
        Q2683 q = new Q2683();
        int[] derived = new int[]{1,1,0};

        boolean x = q.doesValidArrayExist(derived);
        System.out.println(x);
    }


    public boolean doesValidArrayExist(int[] derived) {
        int result = Arrays.stream(derived).reduce(0, (a, b) -> a ^ b);
        return result == 0;
    }
}
