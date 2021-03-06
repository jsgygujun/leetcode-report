package com.jsgygujun.code.problem._00001_00100._00014_最长公共前缀;

import org.junit.Assert;
import org.junit.Test;

/**
 * 14. 最长公共前缀
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); ++i) {
            for (int j = 1; j < strs.length; ++j) {
                if (strs[j].length() < i+1 || strs[j].charAt(i) != strs[0].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    @Test
    public void test() {
        Assert.assertEquals("fl", new Solution().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    @Test
    public void test_2() {
        Assert.assertEquals("", new Solution().longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}


