package com.jsgygujun.code.problem._00001_00100._00050;

import org.junit.Test;

/**
 * 50. Pow(x, n)
 *
 * 题目：
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例1：
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例2：
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例3：
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 * 说明：
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (x == 0) return 0;
        int sign = n > 0 ? 1 : -1;
        long N = Math.abs((long)n);
        double ans = 1.0;
        while (N > 0) {
            if ((N & 1) == 1) {
                ans *= x;
            }
            x *= x;
            N >>= 1;
        }
        return sign > 0 ? ans : 1.0/ans;
    }

    @Test
    public void test() {
        System.out.println(new Solution().myPow(2.0, 10));
        System.out.println(new Solution().myPow(2.1, 3));
        System.out.println(new Solution().myPow(2, -2));
    }

    @Test
    public void test2() {
        System.out.println(new Solution().myPow(2, -2147483648));
    }
}
