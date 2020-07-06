package com.jsgygujun.code.problem._00001_00100._00063;

import org.junit.Assert;
import org.junit.Test;

/**
 * 63. 不同路径 II
 *
 * 题目：
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 * 输出: 2
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 *
 */
public class Solution {
    // dp[i][j] 从[0][0]坐标到[i][j]坐标一共有的路径
    // dp[i][0] = dp[0][i] = obstacleGrid == 0 ? 1 : 0
    // dp[i][j] = 0 if obstacleGrid[i][j] = 0;
    // dp[i][j] = dp[i-1][j] + dp[i][j-1]
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid.length == 0) return 0;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i < m+1; ++i) dp[i][0] = 0;
        for (int j = 0; j < n+1; ++j) dp[0][j] = 0;
        for (int i = 1; i < m+1; ++i) {
            for (int j = 1; j < n+1; ++j) {
                if (i == 1 && j == 1 && obstacleGrid[0][0] == 0) {
                    dp[i][j] = 1; // 起点
                }
                else if (obstacleGrid[i-1][j-1] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }
        for (int i = 1; i < m+1; ++i) {
            for (int j = 1; j < n+1; ++j) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        int[][] case1 = new int[][]{
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };
        Assert.assertEquals(2, new Solution().uniquePathsWithObstacles(case1));
    }

    @Test
    public void test2() {
        int[][] case2 = new int[][] {
                {1,0}
        };
        Assert.assertEquals(0, new Solution().uniquePathsWithObstacles(case2));
    }
}
