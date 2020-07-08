package com.jsgygujun.code.problem._00001_00100._00009;

import org.junit.Assert;
import org.junit.Test;

/**
 * 9-回文数
 *
 * 题目：
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例1：
 * 输入: 121
 * 输出: true
 *
 * 示例2：
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例3：
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int a = x, y = 0;
        while (a > 0) {
            y = y * 10 + a % 10;
            a /= 10;
        }
        return x == y;
    }

    @Test
    public void test1() {
        Assert.assertTrue(new Solution().isPalindrome(121));
        Assert.assertFalse(new Solution().isPalindrome(-121));
        Assert.assertFalse(new Solution().isPalindrome(10));
    }
}
