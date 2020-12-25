package com.jsgygujun.code.problem._00501_00600._00557_反转字符串中的单词3;

import org.junit.Test;

/**
 * 557. 反转字符串中的单词 III
 *
 * 题目：
 * 给定一个字符串，你需要反转字符串中每个单词的字符顺序，同时仍保留空格和单词的初始顺序。
 *
 * 示例：
 * 输入："Let's take LeetCode contest"
 * 输出："s'teL ekat edoCteeL tsetnoc"
 *
 * @author GuJun
 * @date 2020/12/25
 */
public class Solution {
    public String reverseWords(String s) {
        int slow, fast = -1;
        char[] chars = s.toCharArray();
        for (int i = 0; i <= chars.length; ++i) {
            if (i == chars.length || chars[i] == ' ') {
                slow = fast;
                fast = i;
                // swap(slow+p, fast-p), i = 1, 2, ... (fast-i) >= slow+i;
                for (int p = 1; slow+p < fast-p; ++p) {
                    swap(slow+p, fast-p, chars);
                }
            }
        }
        return new String(chars);
    }

    void swap(int i, int j, char[] chars) {
        char c = chars[i];
        chars[i] = chars[j];
        chars[j] = c;
    }

    @Test
    public void test() {
        String str = "Let's take LeetCode contest";
        System.out.println(new Solution().reverseWords(str));
    }
}
