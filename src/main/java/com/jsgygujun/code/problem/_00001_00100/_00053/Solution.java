package com.jsgygujun.code.problem._00001_00100._00053;

import org.junit.Assert;
import org.junit.Test;

/**
 * 53-最大子序和
 *
 * 题目：
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class Solution {
    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for (int j = 0; j < nums.length; ++j) {
            sum += nums[j];
            ans = Math.max(ans, sum);
            sum = Math.max(0, sum);
        }
        return ans;
    }

    @Test
    public void test_1() {
        Assert.assertEquals(6, new Solution().maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
