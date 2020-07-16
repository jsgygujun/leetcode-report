package com.jsgygujun.code.problem._00001_00100._00069;

import org.junit.Assert;
import org.junit.Test;

/**
 * 69. x 的平方根
 *
 * 题目：
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 *
 * 示例 1:
 * 输入: 4
 * 输出: 2
 *
 * 示例 2：
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 *      由于返回类型是整数，小数部分将被舍去。
 *
 */
public class Solution {
    // 在[0,x]中 查找n^2 <= x 的右边界
    public int mySqrt(int x) {
        long lo = 0, hi = x;
        while (lo < hi) {
            long mid = lo + (hi-lo)/2;
            long s = mid * mid;
            //System.out.println("lo:"+lo+",hi:"+hi+",mid:"+mid+",s:"+s);
            if (s == x) return (int)mid;
            else if (s < x) lo = mid+1;
            else hi = mid;
        }
        return lo * lo > x ? (int)(lo-1) : (int)lo;
    }

    @Test
    public void test() {
        Assert.assertEquals(2, new Solution().mySqrt(4));
    }

    @Test
    public void test2() {
        Assert.assertEquals(2, new Solution().mySqrt(8));
    }

    @Test
    public void test3() {
        Assert.assertEquals(1, new Solution().mySqrt(1));
    }

    @Test
    public void test4() {
        Assert.assertEquals(46339, new Solution().mySqrt(2147395599));
    }
}
