package com.jsgygujun.code.problem._00001_00100._00003;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 *
 * 题目：
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1：
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例2：
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例3：
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口
        if (s.length() == 0) return 0;
        Map<Character, Integer> lookup = new HashMap<>();
        int res = 0, left = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (lookup.containsKey(s.charAt(i))) {
                left = Math.max(left, lookup.get(s.charAt(i)) + 1); // 只有当left需要往右边变动时才更新。
            }
            lookup.put(s.charAt(i), i); // 保存每个字符的最新下标
            res = Math.max(res, i-left+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }
}
