package com.jsgygujun.code.problem._00209;

import org.junit.Assert;
import org.junit.Test;

/**
 * 209-长度最小的子数组
 *
 * 题目：
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 *
 * 示例：
 * 输入：s = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
 */
public class Solution {
    // 双指针法，滑动窗口
    // sum < s, 扩大窗口
    // sum >= s, 缩小窗口
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int i = 0, j = 0, sum = 0;
        while (j < nums.length) {
            sum += nums[j];
            while (sum >= s) {
                ans = Math.min(ans, j - i +1);
                sum -= nums[i];
                ++i;
            }
            ++j;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    @Test
    public void test_1() {
        Solution sol = new Solution();
        Assert.assertEquals(2, sol.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
