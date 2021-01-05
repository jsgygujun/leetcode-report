package com.jsgygujun.code.problem._00501_00600._00509_斐波那契数;

import org.junit.Assert;
import org.junit.Test;

/**
 * 509-斐波那契数
 *
 * 题目：
 * 斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 给定 N，计算 F(N)。
 *
 * 示例1：
 * 输入：2
 * 输出：1
 * 解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 * 示例2：
 * 输入：3
 * 输出：2
 * 解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 *
 * 示例3：
 * 输入：4
 * 输出：3
 * 解释：F(4) = F(3) + F(2) = 2 + 1 = 3.
 */
public class Solution {
    // dp[n] = dp[n-1] + dp[n-2]
    // dp[n] = 1, n = 1,2
    public int fib(int N) {
        int[] dp = new int[N+2];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < N+1; ++i) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[N];
    }

    @Test
    public void test_1() {
        Solution sol = new Solution();
        Assert.assertEquals(1, sol.fib(2));
        Assert.assertEquals(2, sol.fib(3));
        Assert.assertEquals(3, sol.fib(4));
    }

}
