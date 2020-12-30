package com.jsgygujun.code.problem._00001_00100._00043_字符串相乘;

import org.junit.Test;

import java.util.Arrays;

/**
 * 43. 字符串相乘
 *
 * 题目：
 *  给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * @Author GuJun
 * @Date 2020/12/30
 */
public class Solution {

    /**
     *          1  2  3
     *          4  5  6
     *                X
     *             1  8
     *          1  2
     *          6
     *          1  5
     *       1  0
     *          5
     *       1  2
     *       8
     *     4
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length(), len2 = num2.length();
        if (num1.equals("0") || num2.equals("0")) return "0";
        int[] num = new int[len1+len2];
        Arrays.fill(num, 0);
        for (int i = len1-1; i >= 0; --i) {
            for (int j = len2-1; j >= 0; --j) {
                int n = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int sum = num[i+j+1] + n;
                num[i+j+1] = sum % 10;
                num[i+j] += sum / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length; ++i) {
            if (i == 0 && num[i] == 0) continue;
            sb.append(num[i]);
        }
        return sb.toString();
    }

    @Test
    public void test() {
        String num1 = "123";
        String num2 = "456";
        System.out.println(new Solution().multiply(num1, num2));
    }
}
