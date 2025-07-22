package com.chestnut.aigc.likou.bitoperation;

public class Q1342 {

    public static void main(String[] args) {
        Q1342 q = new Q1342();
        int num = 4;
        int i = q.numberOfSteps(num);
        System.out.println(i);
    }

    public int numberOfSteps(int num) {
        int divides2Count = 32 - Integer.numberOfLeadingZeros(num) - 1;
        int subtract1Count= Integer.bitCount(num);
        return num == 0 ? 0 : divides2Count + subtract1Count;
    }
}
