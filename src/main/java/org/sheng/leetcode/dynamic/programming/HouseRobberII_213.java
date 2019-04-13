package org.sheng.leetcode.dynamic.programming;


/**
 * @author sheng 2019/4/13
 * @desc todo
 * 环形排列的房子，同样考虑最后一个房子偷或者不偷
 * 不偷则跟普通 HouseRobber 问题一样，考虑前 n - 1 个房子，同时不需要考虑环形排列的问题
 * 偷则去掉第一个房子，考虑第二个房子到第 n - 2 个房子的偷房子最大值，这个区间也不需要考虑环形排列问题，与上一个结果比较得出结论
 * <p>
 * 所以本题依赖 HouseRobber 的基本解法，再来考虑最后一个房子偷不偷
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        return Math.max(normalHouseRobber(nums, 0, length - 2), nums[length - 1] + normalHouseRobber(nums, 1, length - 3));
    }

    private int normalHouseRobber(int[] nums, int begin, int end) {
        if (begin > end) {
            return 0;
        }

        int[] res = new int[end - begin + 2];
        res[0] = 0;
        res[1] = nums[begin];

        for (int i = 2; i <= end - begin + 1; i++) {
            res[i] = Math.max(res[i - 1], nums[i + begin - 1] + res[i - 2]);
        }

        return res[end - begin + 1];
    }
}
