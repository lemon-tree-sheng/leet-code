package org.sheng.leetcode.dynamic.programming;

/**
 * @author sheng 2019/4/13
 * @desc todo
 */
public class UniquePathsII {

    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};

        System.out.println(new UniquePathsII().uniquePathsWithObstacles(obstacleGrid));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null) {
            return 0;
        }

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] res = new int[m][n];
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1) {
                break;
            }
            res[0][i] = 1;
        }

        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                break;
            }
            res[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (obstacleGrid[i][j] == 0) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }

            }

        }

        return res[m - 1][n - 1];
    }
}
