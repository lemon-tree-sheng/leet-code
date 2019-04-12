package org.sheng.leetcode.dynamic.programming;

/**
 * @author sheng 2019/4/11
 * <p>
 * submission: success
 * doc: todo
 */
public class DecodeWays_91 {

    public int numDecodings(String s) {
        int n = s.length();

        if (n == 0) {
            return 0;
        }

        String firstNum = s.substring(0, 1);
        if ("0".equals(firstNum)) {
            return 0;
        }

        int[] res = new int[n + 1];
        res[0] = 1;
        res[1] = 1;

        for (int i = 2; i <= n; i++) {
            String currentNum = s.substring(i - 1, i);
            String previousNum = s.substring(i - 2, i - 1);
            if (!"0".equals(currentNum)) {
                res[i] += res[i - 1];
                if (!"0".equals(previousNum) && Integer.valueOf(previousNum + currentNum) <= 26) {
                    res[i] += res[i - 2];
                }
            } else {
                if ("1".equals(previousNum) || "2".equals(previousNum)) {
                    res[i] += res[i - 2];
                } else {
                    return 0;
                }
            }
        }

        return res[n];
    }

}
