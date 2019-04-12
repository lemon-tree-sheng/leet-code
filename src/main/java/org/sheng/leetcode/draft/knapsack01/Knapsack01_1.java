package org.sheng.leetcode.draft.knapsack01;

/**
 * @author sheng 2019/3/9
 * @desc 0-1 背包问题
 */
public class Knapsack01_1 {

    /**
     * @param weights
     * @param values
     * @param capacity
     * @return
     */
    public int knapsack(int[] weights, int[] values, int capacity) {
        return knapsack(weights, values, weights.length - 1, capacity);
    }

    public int knapsack(int[] weights, int[] values, int index, int capacity) {
        if (capacity == 0 || index == -1) {
            return 0;
        }

        int result1 = knapsack(weights, values, index - 1, capacity);
        int result2 = 0;
        if (capacity >= weights[index]) {
            result2 = values[index] + knapsack(weights, values, index - 1, capacity - weights[index]);
        }

        return Math.max(result1, result2);
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3};
        int[] values = new int[]{6, 10, 12};
        int capacity = 5;

        int result = new Knapsack01_1().knapsack(weights, values, capacity);

        System.out.println(String.format("best value is : %d", result));
    }


}
