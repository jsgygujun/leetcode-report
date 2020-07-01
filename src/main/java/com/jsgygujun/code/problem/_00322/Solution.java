package com.jsgygujun.code.problem._00322;

import org.junit.Assert;
import org.junit.Test;

/**
 * 322-零钱兑换
 *
 * 题目：
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 *
 * 示例1：
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 *
 * 示例2：
 * 输入: coins = [2], amount = 3
 * 输出: -1
 *
 * 说明：
 * 你可以认为每种硬币的数量是无限的。
 */
public class Solution {
    // dp[n]: amount=n时，最少的硬币个数
    // dp[n] = -1, n < 0;
    // dp[n] = 0, n = 0;
    // dp[n] = min(dp[n-coin]+1) for coin in coins
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        dp[0] = 0; // 边界条件
        for (int i = 1; i < amount+1; ++i) {
            dp[i] = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i-coin >= 0 && dp[i-coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i-coin]+1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    @Test
    public void test() {
        Solution sol = new Solution();
        Assert.assertEquals(3, sol.coinChange(new int[]{1,2,5}, 11));
        Assert.assertEquals(-1, sol.coinChange(new int[]{2}, 3));
    }
}
