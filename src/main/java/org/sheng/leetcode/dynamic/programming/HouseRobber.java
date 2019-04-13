package org.sheng.leetcode.dynamic.programming;

/**
 * @author sheng 2019/4/13
 * @desc todo
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }

        int length = nums.length;
        if (length == 0) {
            return 0;
        }

        int[] res = new int[length + 1];

        res[0] = 0;
        res[1] = nums[0];

        for (int i = 2; i <= length; i++) {
            res[i] = Math.max(res[i - 1], nums[i - 1] + res[i - 2]);
        }

        return res[length];
    }

}
