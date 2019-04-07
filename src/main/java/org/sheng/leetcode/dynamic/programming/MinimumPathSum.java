package org.sheng.leetcode.dynamic.programming;

/*
 * @lc app=leetcode id=64 lang=java
 *
 * [64] Minimum Path Sum
 *
 * https://leetcode.com/problems/minimum-path-sum/description/
 *
 * algorithms
 * Medium (45.79%)
 * Total Accepted:    218.7K
 * Total Submissions: 474K
 * Testcase Example:  '[[1,3,1],[1,5,1],[4,2,1]]'
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 *
 * Note: You can only move either down or right at any point in time.
 *
 * Example:
 *
 *
 * Input:
 * [
 * [1,3,1],
 * ⁠ [1,5,1],
 * ⁠ [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 *
 * 状态转移方程：
 *  F(m,n) = min[F(m - 1, n), F(m, n - 1)] + grid[m][n]
 * 递推初始条件：
 *  F(0,0) = grid[0][0] (m = 1, n = 1)
 *  F(0,n) = F(0, n - 2) + grid[0][n - 1] (m = 1)
 *  F(m, 0) = F(m - 2, 0) + grid[m - 1][0] (n = 1)
 */
public class MinimumPathSum {

    public int minPathSum(int[][] grid) {
        if (grid == null) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        int[][] res = new int[m][n];
        res[0][0] = grid[0][0];

        for (int i = 1; i < n; i++) {
            res[0][i] = res[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[i][j] = Math.min(res[i - 1][j], res[i][j - 1]) + grid[i][j];
            }
        }

        return res[m - 1][n - 1];
    }
}
