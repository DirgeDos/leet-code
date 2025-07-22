package com.chestnut.aigc.likou.bitoperation;

public class Q868 {

    public static void main(String[] args) {
        Q868 q = new Q868();
        int num = 22;
        int i = q.binaryGap(num);
        System.out.println(i);
    }

    public int binaryGap(int n) {
        int len = 32 - Integer.numberOfLeadingZeros(n);
        int maxNum = 0;
        for (int i = 0; i < len - 2; i++) {
            int mask = (1 << (len - 1 - i)) + 1;
            for (int i1 = 0; i1 < i + 1; i1++) {
                int num = n & mask;
                if (num == mask) {
//                    maxNum = Math.max(maxNum, len - i - 1);
                }
                mask <<= 1;

            }
        }
        return maxNum;
    }
}
