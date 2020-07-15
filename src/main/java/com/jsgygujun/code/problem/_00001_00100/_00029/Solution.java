package com.jsgygujun.code.problem._00001_00100._00029;

import org.junit.Assert;
import org.junit.Test;

/**
 * 29. 两数相除
 *
 * 题目：
 * 给定两个整数，被除数 dividend 和除数 divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
 *
 * 返回被除数 dividend 除以除数 divisor 得到的商。
 *
 * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
 *
 * 示例 1:
 * 输入: dividend = 10, divisor = 3
 * 输出: 3
 * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
 *
 * 示例 2:
 * 输入: dividend = 7, divisor = -3
 * 输出: -2
 * 解释: 7/-3 = truncate(-2.33333..) = -2
 *
 * 提示：
 * 被除数和除数均为 32 位有符号整数。
 * 除数不为 0。
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。本题中，如果除法结果溢出，则返回 231 − 1。
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) return 0;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend == Integer.MIN_VALUE && divisor == 1) return Integer.MIN_VALUE;
        int sign = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0) ? 1 : -1;
        long dividend_ = Math.abs((long)dividend);
        long divisor_ = Math.abs((long)divisor);
        if (dividend_ < divisor_) return 0;
        int n = 0, ans = 0;
        while (true) {
            if (dividend_-(divisor_<<n) >= 0) {
                ans += ( 1 << n);
                dividend_ -= (divisor_ << n);
                ++n;
            } else if (n == 0) {
                break;
            } else {
                --n;
            }
        }
        return sign == 1 ? ans : -ans;
    }



    @Test
    public void test() {
        Assert.assertEquals(3, new Solution().divide(10, 3));
    }

    @Test
    public void test2() {
        Assert.assertEquals(-2, new Solution().divide(7, -3));
    }

    @Test
    public void test3() {
        Assert.assertEquals(-1073741824, new Solution().divide(-2147483648, 2));
    }

    @Test
    public void test4() {
        System.out.println(new Solution().divide(65535, 2));
    }

}
