package com.chestnut.aigc.likou.bitoperation;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q1442_f {

    public static void main(String[] args) {
        Q1442_f q = new Q1442_f();
        int[] arr = new int[]{2, 3, 1, 6, 7};

        int x = q.countTriplets(arr);
        System.out.println(x);
    }


    public int countTriplets(int[] arr) {
        int n = arr.length;
        // 预处理前缀异或数组
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] ^ arr[i - 1];
        int ans = 0;
        // 记录出现过的异或结果，存储格式：{ 异或结果 : [下标1, 下标2 ...] }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int k = 0; k <= n; k++) {
            List<Integer> list = map.getOrDefault(sum[k], new ArrayList<>());
            for (int idx : list) {
                int i = idx + 1;
                ans += k - i;
            }
            list.add(k);
            map.put(sum[k], list);
        }
        return ans;
    }
}
