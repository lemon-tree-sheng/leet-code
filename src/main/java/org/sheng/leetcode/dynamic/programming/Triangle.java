package org.sheng.leetcode.dynamic.programming;

import java.util.List;

/*
 * @lc app=leetcode id=120 lang=java
 *
 * [120] Triangle
 *
 * https://leetcode.com/problems/triangle/description/
 *
 * algorithms
 * Medium (38.51%)
 * Total Accepted:    174.8K
 * Total Submissions: 450.7K
 * Testcase Example:  '[[2],[3,4],[6,5,7],[4,1,8,3]]'
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step
 * you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 *
 * [
 * ⁠    [2],
 * ⁠   [3,4],
 * ⁠  [6,5,7],
 * ⁠ [4,1,8,3]
 * ]
 *
 *
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 *
 * 思考：
 *  典型的动态规划没错，但是很快会发现从头开始存储子问题结果的思路不行，因为后面每一行的最小值都不能确定为我们的答案，最后结果会成为一个树形，相当于没有结果；
 *  那么我们反过来想，我们让每个节点存储从它开始直到最后的节点路径和，由于从下到上条件是慢慢收紧的，问题逐渐被解决，这也为我们以后思考其他这种树形问题提供思
 *  路，我们可以从树的底部开始思考。
 *
 * 题目所给矩阵可以转化为一个 m x m 的矩阵
 * 设：
 *  坐标为 i, j 的点到底部的最小的路径和为 F(i, j)
 *
 * 则：
 *  F(m, i) = triangle[m][i] // 初始化最后一行
 *  F(i, j) = min{F(i + 1, j), F(i + 1, j + 1} + triangle[i][j]
 *
 */
public class Triangle {

    /**
     * @param triangle 这里给的是一个二维的线性表，每一行可以存储的长度不需要相同，这里写 java 的同学需要注意，按照二维数组的方式来处理
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        // 参数防御工作
        if (triangle == null) {
            return 0;
        }
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        if (m == 0 || n == 0 || m != n) {
            return 0;
        }

        // 初始化结果的存储位置
        int[][] res = new int[m][m];
        // 初始化最后一行结果
        List<Integer> lastList = triangle.get(m - 1);
        for (int i = 0; i < m; i++) {
            res[m - 1][i] = lastList.get(i);
        }

        // 开始动态规划过程，计算子结果并存储
        for (int i = m - 2; i >= 0; i--) {
            List<Integer> currentList = triangle.get(i);
            for (int j = 0; j <= i; j++) {
                res[i][j] = Math.min(res[i + 1][j], res[i + 1][j + 1]) + currentList.get(j);
            }
        }

        return res[0][0];
    }
}
