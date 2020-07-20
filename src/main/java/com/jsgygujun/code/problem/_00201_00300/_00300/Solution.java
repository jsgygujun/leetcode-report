package com.jsgygujun.code.problem._00201_00300._00300;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * 300-最长上升子序列
 *
 * 题目：
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 *
 * 示例:
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 * 1. 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 2. 你算法的时间复杂度应该为 O(n2) 。
 *
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 */
public class Solution {
    public int lengthOfLIS(int[] nums) {
        // dp[i]: 以nums[i]结尾的最长上升子序列
        // dp[0] = 1
        // dp[i] = max(dp[j]) when nums[j] < nums[i] and j < i
        final int n = nums.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        // 初始化dp[i] = 1, i = 0,...,n
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    @Test
    public void test() {
        Assert.assertEquals(4, new Solution().lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(0, new Solution().lengthOfLIS(new int[]{}));
    }

    @Test
    public void test_3() {
        Assert.assertEquals(6, new Solution().lengthOfLIS(new int[]{1,3,6,7,9,4,10,5,6}));
    }


}
