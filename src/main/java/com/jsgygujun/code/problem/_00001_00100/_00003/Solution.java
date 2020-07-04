package com.jsgygujun.code.problem._00003;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
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
