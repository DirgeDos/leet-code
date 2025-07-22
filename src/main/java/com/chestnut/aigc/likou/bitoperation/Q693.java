package com.chestnut.aigc.likou.bitoperation;

public class Q693 {

    public static void main(String[] args) {
        Q693 q = new Q693();
        int num = 7;
        boolean i = q.hasAlternatingBits(num);
        System.out.println(i);
    }

    public boolean hasAlternatingBits(int n) {
        int k = 32 - Integer.numberOfLeadingZeros(n);
        for (int i = 1; i < k; i++) {
            int bitSite = Double.valueOf(Math.pow(2, i)).intValue();
            int lastBitSite = Double.valueOf(Math.pow(2, i - 1)).intValue();
            if (((n & bitSite) == bitSite) == ((n & lastBitSite) == lastBitSite)) {
                return false;
            }
        }
        return true;
    }
}
