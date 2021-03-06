package com.jsgygujun.code.problem._00001_00100._00005_最长回文子串;

import org.junit.Test;

/**
 * 5. 最长回文子串
 *
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 */
public class Solution {
    // dp[i][j]: s[i:j]是否为回文子串
    // 特殊值：
    //   1. dp[i][j] = true;
    //   2. dp[i][i+1] = s[i] == s[i+1] ? true : false
    // 递推关系：
    // dp[i][j] = (dp[i+1][j-1] == true && s[i] == s[j]) ? true : false;
    public String longestPalindrome(String s) {
        if (s.isEmpty()) return s;
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int L = 0, R = 0, maxLen = 1;
        // 重点：从较短的子串向较长子串递推
        for (int l = 0; l < n; ++l) { // 控制子串长度
            for (int i = 0; i < n; ++i) {
                int j = i + l;
                if (j >= n || i+1 >= n || j-1 < 0) continue;
                if (i == j || ((s.charAt(i) == s.charAt(j)) && (j == i+1 || dp[i+1][j-1]))) {
                    dp[i][j] = true;
                    if (maxLen < j-i+1) {
                        maxLen = j-i+1;
                        L = i;
                        R = j;
                    }
                }
            }
        }
        return s.substring(L, R+1);
    }

    public String longestPalindrome2(String s) {
        int ansL = 0, ansR = 0;
        int ansLen = 0;
        // "aba" 的情况
        for (int i = 0; i < s.length(); ++i) {
            int l = i, r = i;
            for (int p = 0; p <= s.length()/2; ++p) {
                l = l - p;
                r = r + p;
                if (l < 0 || r >= s.length()) break;
                if (s.charAt(l) != s.charAt(r)) break;
                if (r-l > ansLen) {
                    ansLen = r-l;
                    ansL = l;
                    ansR = r;
                }
            }
        }
        // "aa" 的情况
        for (int i = 0; i < s.length()-1; ++i) {
            int l = i, r = i+1;
            for (int p = 0; p <= s.length()/2; ++p) {
                l = l - p;
                r = r + p;
                if (l < 0 || r >= s.length()) break;
                if (s.charAt(l) != s.charAt(r)) break;
                if (r-l > ansLen) {
                    ansLen = r-l;
                    ansL = l;
                    ansR = r;
                }
            }
        }
        return s.substring(ansL, ansR+1);
    }

    @Test
    public void test() {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome("abcba"));
    }

    @Test
    public void test2() {
//        System.out.println(new Solution().longestPalindrome2("babad"));
//        System.out.println(new Solution().longestPalindrome2("cbbd"));
//        System.out.println(new Solution().longestPalindrome2("abcba"));
        System.out.println(new Solution().longestPalindrome2("ccc"));
    }
}
