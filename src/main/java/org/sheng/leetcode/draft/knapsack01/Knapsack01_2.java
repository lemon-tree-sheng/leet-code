package org.sheng.leetcode.draft.knapsack01;

/**
 * @author sheng 2019/3/9
 * @desc 0-1 背包问题
 */
public class Knapsack01_2 {

    private int knapsack(int[] weights, int[] values, int capacity) {
        int size = weights.length;

        int[][] cache = new int[size][capacity + 1];
        return knapsack(weights, values, size - 1, capacity, cache);
    }

    private int knapsack(int[] weights, int[] values, int index, int capacity, int[][] cache) {

        if (capacity == 0 || index == -1) {
            return 0;
        }

        if (cache[index][capacity] != 0) {
            return cache[index][capacity];
        }

        int result1 = knapsack(weights, values, index - 1, capacity, cache);

        int result2 = 0;
        if (capacity >= weights[index]) {
            result2 = values[index] + knapsack(weights, values, index - 1, capacity - weights[index], cache);
        }

        cache[index][capacity] = Math.max(result1, result2);

        return cache[index][capacity];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3};
        int[] values = new int[]{6, 10, 12};
        int capacity = 5;

        int result = new Knapsack01_2().knapsack(weights, values, capacity);

        System.out.println(String.format("best value is : %d", result));
    }


}
