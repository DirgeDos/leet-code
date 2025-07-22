package com.chestnut.aigc.likou.bitoperation;


import java.util.Arrays;

public class Q2317 {

    public static void main(String[] args) {
        Q2317 q = new Q2317();
        int[] nums = new int[]{3, 2, 4, 6};

        int x = q.maximumXOR(nums);
        System.out.println(x);
    }


    public int maximumXOR(int[] nums) {
        return Arrays.stream(nums).reduce(0, (a, b) -> a | b);
    }
}
