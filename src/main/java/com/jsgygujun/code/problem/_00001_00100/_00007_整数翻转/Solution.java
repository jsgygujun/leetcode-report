package com.jsgygujun.code.problem._00001_00100._00007_整数翻转;

/**
 * 7. 整数反转
 *
 * 题目：
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例 1:
 * 输入: 123
 * 输出: 321
 *
 * 示例 2:
 * 输入: -123
 * 输出: -321
 *
 * 示例 3:
 * 输入: 120
 * 输出: 21
 */
public class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        int res = 0;
        x = Math.abs(x);
        while (x > 0) {
            int r = x % 10;
            // 溢出条件，其中7是2^32-1的个位
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && r > 7)) return 0;
            res = res * 10 + r;
            x /= 10;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
    }

    public int reverse2(int x) {
        int sign = x >= 0 ? 1 : -1;
        x = Math.abs(x);
        long res = 0;
        while (x > 0) {
            int r = x % 10;
            res = res * 10 + r;
            x /= 10;
        }
        res = sign * res;
        return (res >= Integer.MIN_VALUE && res <= Integer.MAX_VALUE) ? (int)res : 0;
    }
}
