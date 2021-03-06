package com.jsgygujun.code.problem._00001_00100._00072;

import org.junit.Assert;
import org.junit.Test;

/**
 * 72-编辑距离
 *
 * 题目：
 * 给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。
 *
 * 你可以对一个单词进行如下三种操作：
 *
 * 1. 插入一个字符
 * 2. 删除一个字符
 * 3. 替换一个字符
 *
 * 示例1：
 * 输入：word1 = "horse", word2 = "ros"
 * 输出：3
 * 解释：
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 *
 * 示例2：
 * 输入：word1 = "intention", word2 = "execution"
 * 输出：5
 * 解释：
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 *
 */
public class Solution {
    public int minDistance(String word1, String word2) {
        // dp[i][j]: word1[1,...,i]和word2[1,...,j]的最小编辑距离，下标从1开始
        // dp[i][0] = i, dp[0][j] = j
        // dp[i][j] = dp[i-1][j-1] if word1[i-1] == word2[j-1]
        // dp[i][j] = min(dp[i][j-1], dp[i-1][j-1], dp[i-1][j]) + 1 if word1[i-1] != word2[j-1]
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int j = 0; j <= n; ++j) {
            dp[0][j] = j;
        }
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]))+1;
                }
            }
        }
        return dp[m][n];
    }

    @Test
    public void test() {
        Assert.assertEquals(3, new Solution().minDistance("horse", "ros"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(5, new Solution().minDistance("intention", "execution"));
    }
}
