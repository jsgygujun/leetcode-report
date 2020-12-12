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
 * 解释: 因为无重复字符的最长子串是「"wke"」，所以其长度为 3。
 * 请注意，你的答案必须是「子串」的长度，「"pwke"」是一个子序列，不是子串。
 *
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 滑动窗口 [left, right], len = right-left+1
        if (s.length() == 0) return 0;
        Map<Character, Integer> map = new HashMap<>(); // 保存每个字符的最新下标
        int len = 0, left = 0;
        for (int right = 0; right < s.length(); ++right) {
            if (map.containsKey(s.charAt(right))) {
                left = Math.max(left, map.get(s.charAt(right))+1); // 只有当left需要往右边变动时才更新。
            }
            map.put(s.charAt(right), right); // 保存每个字符的最新下标
            len = Math.max(len, right-left+1);
        }
        return len;
    }

    // 套用模版
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>(s.length()); // 保存每个字符的最新下标 c -> idx
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right); // 将要加入滑动窗口的字符
            right++;
            if (map.containsKey(c) && left <= map.get(c)) { // 判断滑动窗口是否需要缩小。需要缩小的条件：当前加入的字符「c」已经在滑动窗口中
                left = map.get(c) + 1;
            }
            map.put(c, right-1);
            maxLen = Math.max(maxLen, (right-left));
        }
        return maxLen;
    }

    // 套用模版2
    public int lengthOfLongestSubstring3(String s) {
        if (s == null || s.length() == 0) return 0;
        int left = 0, right = 0;
        Map<Character, Integer> map = new HashMap<>(s.length()); // 记录「滑动窗口中」字符所在的下标
        int maxLen = 0;
        while (right < s.length()) {
            char c = s.charAt(right); // 将要加入滑动窗口的字符
            right++;
            if (map.containsKey(c)) { // 滑动窗口需要缩小条件： 将要加入的字符已经存在与当前滑动窗口中
                int idx = map.get(c); // left 需要移动到idx+1处, 同时需要删除map中已经移处滑动窗口的元素
                while (left <= idx) {
                    map.remove(s.charAt(left));
                    left++;
                }
            }
            map.put(c, right-1);
            maxLen = Math.max(maxLen, right-left);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Solution().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new Solution().lengthOfLongestSubstring("abba"));
    }

    // 滑动窗口模版，滑动窗口元素: [left, right], 窗口大小: right-left+1
//    void slidingWindowTemplate(String s) {
//        int left = 0, right = 0;
//        while (right < s.length()) {
//            char c = s.charAt(right); // 「c」是将要移入窗口的字符
//            // 进行窗口内数据的更新
//            while (窗口需要缩小的条件) {
//                char d = s.charAt(left);
//                left++;
//                // 进行窗口内数据的更新
//            }
//            right++;
//        }
//    }
}
