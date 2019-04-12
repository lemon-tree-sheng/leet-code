package org.sheng.leetcode.dynamic.programming;

import java.util.Arrays;

/**
 * @author sheng 2019/4/11
 * <p>
 * submission: success
 * doc: todo
 */
public class PerfectSquares {

    public int numSquares(int n) {
        int[] res = new int[n + 1];
        Arrays.fill(res, Integer.MAX_VALUE);

        for (int i = 0; i * i <= n; i++) {
            res[i * i] = 1;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; i - j * j >= 0; j++) {
                res[i] = Math.min(res[i], res[i - j * j] + 1);
            }
        }

        return res[n];
    }

}
