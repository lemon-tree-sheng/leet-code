package org.sheng.leetcode.draft.knapsack01;

/**
 * @author sheng 2019/3/9
 * @desc 0-1 背包问题
 */
public class Knapsack01_3 {

    private int knapsack(int[] weights, int[] values, int capacity) {
        int size = weights.length;
        int[][] cache = new int[size][capacity + 1];

        for (int i = 0; i < size; i++) { // 物品
            for (int j = 1; j <= capacity; j++) { // 容量
                // 第 i 个物品放入背包
                int result1 = 0;
                if (weights[i] <= j) {
                    result1 = values[i];
                    if (i > 0 && (j - weights[i] > 0)) {
                        result1 += cache[i - 1][j - weights[i]];
                    }
                }

                // 第 i 个物品不放入背包
                int result2 = 0;
                if (i > 0) {
                    result2 = cache[i - 1][j];
                }

                // 计算最大值并缓存
                cache[i][j] = Math.max(result1, result2);
            }

        }

        return cache[size - 1][capacity];
    }

    public static void main(String[] args) {
        int[] weights = new int[]{1, 2, 3};
        int[] values = new int[]{6, 10, 12};
        int capacity = 5;

        int result = new Knapsack01_3().knapsack(weights, values, capacity);

        System.out.println(String.format("best value is : %d", result));
    }


}
