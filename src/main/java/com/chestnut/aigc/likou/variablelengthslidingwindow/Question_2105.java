package com.chestnut.aigc.likou.variablelengthslidingwindow;

public class Question_2105 {
    public static void main(String[] args) {
        Question_2105 q = new Question_2105();
        int[] plants = new int[]{2,2,5,2,2};
        int xxx = q.minimumRefill(plants, 5, 5);
        System.out.println(xxx);
    }

    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int a = capacityA;
        int b = capacityB;
        int sum = 0;
        int left = 0;
        int right = plants.length - 1;
        while (left < right) {

            if (capacityA < plants[left]) {
                sum++;
                capacityA = a;
            }
            capacityA -= plants[left];
            if (capacityB < plants[right]) {
                sum++;
                capacityB = b;
            }
            capacityB -= plants[right];

            left++;
            right--;
        }
        if (left == right && plants[left] > Math.max(capacityA, capacityB)) {
            sum++;
        }
        return sum;
    }
}
