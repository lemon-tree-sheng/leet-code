package org.sheng.leetcode.dynamic.programming;

/*
 * @lc app=leetcode id=343 lang=java
 *
 * [343] Integer Break
 *
 * https://leetcode.com/problems/integer-break/description/
 *
 * algorithms
 * Medium (47.40%)
 * Total Accepted:    76.3K
 * Total Submissions: 160.6K
 * Testcase Example:  '2'
 *
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get.
 *
 * Example 1:
 *
 *
 *
 * Input: 2
 * Output: 1
 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
 *
 *
 * Example 2:
 *
 *
 * Input: 10
 * Output: 36
 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
 *
 * Note: You may assume that n is not less than 2 and not larger than 58.
 *
 *
 */
public class IntegerBreak {

    public int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }

        int[] res = new int[n + 1];
        res[1] = 1;

        for (int i = 2; i <= n; i++) {

            res[i] = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                res[i] = max(j * res[i - j], j * (i - j), res[i]);
            }

        }

        return res[n];
    }

    private int max(int a, int b, int c) {
        return a > b ? (a > c ? a : c) : (b > c ? b : c);
    }

}
