package org.sheng.leetcode.dynamic.programming;

/**
 * @author sheng 2019/4/13
 * @desc todo
 * <p>
 * 动态规划的本质是最优子结构，子问题答案的记录，由此递推
 * 这里可以用状态机的思路来解题
 */
public class BuyStock_309 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int days = prices.length;
        int[] buy = new int[days];
        int[] sell = new int[days];
        int[] cooldown = new int[days];

        cooldown[0] = 0;
        buy[0] = -prices[0];
        sell[0] = 0;

        for (int i = 1; i < days; i++) {
            buy[i] = Math.max(buy[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + prices[i]);
            cooldown[i] = Math.max(cooldown[i - 1], sell[i - 1]);
        }

        int lastIndex = days - 1;

        return Math.max(Math.max(buy[lastIndex], sell[lastIndex]), cooldown[lastIndex]);
    }
}
