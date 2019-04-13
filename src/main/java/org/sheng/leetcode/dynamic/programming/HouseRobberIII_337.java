package org.sheng.leetcode.dynamic.programming;

/**
 * @author sheng 2019/4/13
 * @desc todo
 * <p>
 * 递归：
 * res = max{[root.val + rob(root.left.left) + rob(root.left.right) + rob(root.right+left) + rob(root.right.right)], [rob(root.left) + rob(root.right)]}
 * <p>
 * 动态规划：
 * 树形问题的动态规划，很好的题目。思路参考：https://leetcode.com/problems/house-robber-iii/discuss/79330/Step-by-step-tackling-of-the-problem
 * <p>
 * 重叠子问题在于每个节点的两种选择造成的结果没有做记录，回溯时当前节点仍然面临两种选择，这两种选择需要重新计算
 */
public class HouseRobberIII_337 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] res = tryRob(root);
        return Math.max(res[0], res[1]);
    }

    private int[] tryRob(TreeNode root) {
        int[] res = new int[2];
        if (root == null) {
            return res;
        }

        int[] left = tryRob(root.left);
        int[] right = tryRob(root.right);

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];

        return res;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
