package com.chestnut.aigc.likou.slidingwindow;

import java.util.HashMap;

public class Question_1052 {
    public static void main(String[] args) {
        Question_1052 q = new Question_1052();
        int[] customers = new int[]{1, 0, 1, 2, 1, 1, 7, 5};
        int[] grumpy = new int[]{0, 1, 0, 1, 0, 1, 0, 0};
        int xx = q.maxSatisfied1(customers, grumpy, 3);
        System.out.println(xx);
    }

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int[] s = new int[2];
        int maxS1 = 0;
        for (int i = 0; i < customers.length; i++) {
            s[grumpy[i]] += customers[i];
            if (i < minutes - 1) { // 窗口长度不足 minutes
                continue;
            }
            maxS1 = Math.max(maxS1, s[1]);
            // 窗口最左边元素离开窗口
            s[1] -= grumpy[i - minutes + 1] > 0 ? customers[i - minutes + 1] : 0;
        }
        return s[0] + maxS1;
    }

    public int maxSatisfied1(int[] customers, int[] grumpy, int minutes) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxGrumpy1 = 0;
        int length = customers.length;
        for (int i = 0; i < length; i++) {
            map.put(grumpy[i], map.getOrDefault(grumpy[i], 0) + customers[i]);
            if (i + 1 < minutes) {
                continue;
            }
            maxGrumpy1 = Math.max(maxGrumpy1, map.getOrDefault(1, 0));
            if (grumpy[i + 1 - minutes] == 1) {
                map.put(1, map.get(1) - customers[i + 1 - minutes]);
            }
        }

        return map.getOrDefault(0, 0) + maxGrumpy1;
    }
}
