package com.jsgygujun.code.problem._00001_00100._00013;

import org.junit.Assert;
import org.junit.Test;


/**
 * 13. 罗马数字转整数
 *
 * 题目：
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II。 27 写做  XXVII, 即为 XX + V + II。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 * 给定一个罗马数字，将其转换成整数。输入确保在 1 到 3999 的范围内。
 *
 */
public class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == 'M') {
                sum += 1000;
            } else if (chars[i] == 'D') {
                sum += 500;
            } else if (chars[i] == 'C') {
                if ((i+1) < chars.length) {
                    if (chars[i+1] == 'M') {
                        sum += 900;
                        ++i;
                    } else if (chars[i+1] == 'D') {
                        sum += 400;
                        ++i;
                    } else {
                        sum += 100;
                    }
                } else {
                    sum += 100;
                }
            } else if (chars[i] == 'L') {
                sum += 50;
            } else if (chars[i] == 'X') {
                if ((i+1) < chars.length) {
                    if (chars[i+1] == 'C') {
                        sum += 90;
                        ++i;
                    } else if (chars[i+1] == 'L') {
                        sum += 40;
                        ++i;
                    } else {
                        sum += 10;
                    }
                } else {
                    sum += 10;
                }
            } else if (chars[i] == 'V') {
                sum += 5;
            } else if (chars[i] == 'I') {
                if ((i+1) < chars.length) {
                    if (chars[i+1] == 'X') {
                        sum += 9;
                        ++i;
                    } else if (chars[i+1] == 'V') {
                        sum += 4;
                        ++i;
                    } else {
                        sum += 1;
                    }
                } else {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    // 加减号问题
    public int romanToInt2(String s) {
        int sum = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; ++i) {
            if (chars[i] == 'M') {
                sum += 1000;
            } else if (chars[i] == 'D') {
                sum += 500;
            } else if (chars[i] == 'C') {
                if ((i+1) < chars.length && (chars[i+1] == 'D' || chars[i+1] == 'M')) {
                    sum -= 100;
                } else {
                    sum += 100;
                }
            } else if (chars[i] == 'L') {
                sum += 50;
            } else if (chars[i] == 'X') {
                if ((i+1) < chars.length && (chars[i+1] == 'L' || chars[i+1] == 'C')) {
                    sum -= 10;
                } else {
                    sum += 10;
                }
            } else if (chars[i] == 'V') {
                sum += 5;
            } else if (chars[i] == 'I') {
                if ((i+1) < chars.length && (chars[i+1] == 'V' || chars[i+1] == 'X')) {
                    sum -= 1;
                } else {
                    sum += 1;
                }
            }
        }
        return sum;
    }

    @Test
    public void test() {
        Assert.assertEquals(3, new Solution().romanToInt2("III"));
    }

    @Test
    public void test_2() {
        Assert.assertEquals(4, new Solution().romanToInt2("IV"));
    }

    @Test
    public void test_3() {
        Assert.assertEquals(9, new Solution().romanToInt2("IX"));
    }

    @Test
    public void test_4() {
        Assert.assertEquals(58, new Solution().romanToInt2("LVIII"));
    }

    @Test
    public void test_5() {
        Assert.assertEquals(1994, new Solution().romanToInt2("MCMXCIV"));
    }
}
