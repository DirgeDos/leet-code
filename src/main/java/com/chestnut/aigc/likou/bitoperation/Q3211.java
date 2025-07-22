package com.chestnut.aigc.likou.bitoperation;


import java.util.ArrayList;
import java.util.List;

public class Q3211 {

    public static void main(String[] args) {
        Q3211 q = new Q3211();
        int n = 3;
        List<String> x = q.validStrings(n);
        System.out.println(x);
    }


    public List<String> validStrings(int n) {
        int mask = (1 << n) - 1;
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < 1 << n; i++) {
            int a = i ^ mask;
            if (((a >> 1) & a) == 0) {
                String replace = String.format("%" + n + "s", Integer.toBinaryString(i)).replace(' ', '0');
                result.add(replace);
            }
        }
        return result;
    }
}
