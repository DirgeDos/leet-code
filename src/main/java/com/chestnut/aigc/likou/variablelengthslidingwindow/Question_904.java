package com.chestnut.aigc.likou.variablelengthslidingwindow;


import java.util.HashMap;

public class Question_904 {
    public static void main(String[] args) {
        Question_904 q = new Question_904();
        int[] nums = new int[]{3,3,3,1,2,1,1,2,3,3,4};
        int xx = q.totalFruit(nums);
        System.out.println(xx);
    }

    public int totalFruit(int[] fruits) {
        int left = 0;
        int max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                int i1 = map.get(fruits[left]) - 1;
                if (i1 <= 0) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                }
                left++;
            }
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}
