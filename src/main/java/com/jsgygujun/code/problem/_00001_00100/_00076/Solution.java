package com.jsgygujun.code.problem._00001_00100._00076;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

/**
 * 76-最小覆盖子串
 *
 * 题目：
 * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 * 输入: S = "ADOBECODEBANC", T = "ABC"
 * 输出: "BANC"
 *
 * 说明：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 *
 * 特别说明： 假如「T」中包含两个"A"，则在给出的覆盖中也必须有两个"A"。
 */
public class Solution {

    Map<Character, Integer> ori = new HashMap<Character, Integer>();
    Map<Character, Integer> cnt = new HashMap<Character, Integer>();

    public String minWindow(String s, String t) {
        int tLen = t.length();
        for (int i = 0; i < tLen; i++) {
            char c = t.charAt(i);
            ori.put(c, ori.getOrDefault(c, 0) + 1);
        }
        int l = 0;
        int len = Integer.MAX_VALUE, ansL = -1, ansR = -1;
        for (int r = 0; r < s.length(); ++r) {
            if (ori.containsKey(s.charAt(r))) {
                cnt.put(s.charAt(r), cnt.getOrDefault(s.charAt(r), 0) + 1);
            }
            while (check() && l <= r) {
                if (r - l + 1 < len) {
                    len = r - l + 1;
                    ansL = l;
                    ansR = l + len;
                }
                if (ori.containsKey(s.charAt(l))) {
                    cnt.put(s.charAt(l), cnt.getOrDefault(s.charAt(l), 0) - 1);
                }
                ++l;
            }
        }

        return ansL == -1 ? "" : s.substring(ansL, ansR);
    }

    public boolean check() {
        Iterator iter = ori.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            Character key = (Character) entry.getKey();
            Integer val = (Integer) entry.getValue();
            if (cnt.getOrDefault(key, 0) < val) {
                return false;
            }
        }
        return true;
    }

    public String minWindow2(String s, String t) {
        Map<Character, Integer> window = new HashMap<>(); // 滑动窗口中包含的字符以及各个字符的个数
        Map<Character, Integer> target = new HashMap<>(); // 目标字符串中包含的字符以及各个字符的个数
        for (int i = 0; i < t.length(); ++i) {
            char c = t.charAt(i);
            target.put(c, target.getOrDefault(c, 0) + 1);
        }
        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++; // 滑动窗口为 [left, right)
            if (isCovered(window, target)) { // 满足覆盖条件
                if (minLen > right-left) {
                    minLen = right-left;
                    ans = s.substring(left, right);
                }
                while (isCovered(window, target)) { // 需要缩小窗口
                    char d = s.charAt(left);
                    left++;
                    int count = window.get(d);
                    if (count == 1) {
                        window.remove(d);
                    } else {
                        window.put(d, count - 1);
                    }
                    if (isCovered(window, target)) { // // 满足覆盖条件
                        if (minLen > right-left) {
                            minLen = right-left;
                            ans = s.substring(left, right);
                        }
                    }
                }
            }
        }
        return ans;
    }

    // 判断是否满足覆盖条件
    private boolean isCovered(Map<Character, Integer> window, Map<Character, Integer> target) {
        if (target.size() > window.size()) return false;
        for (Map.Entry<Character, Integer> entry : target.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value > window.getOrDefault(key, 0)) return false;
        }
        return true;
    }

    @Test
    public void test_1() {
        Solution sol = new Solution();
        Assert.assertEquals("", sol.minWindow("", ""));
        Assert.assertEquals("BANC", sol.minWindow("ADOBECODEBANC", "ABC"));
    }

    @Test
    public void test_2() {
        Solution sol = new Solution();
        //Assert.assertEquals("", sol.minWindow2("", ""));
        //Assert.assertEquals("BANC", sol.minWindow2("ADOBECODEBANC", "ABC"));
        //Assert.assertEquals("cwae", sol.minWindow2("cabwefgewcwaefgcf", "cae"));
        Assert.assertEquals("a", sol.minWindow2("a", "a"));
    }

    // 滑动窗口模版
//    void slidingWindow(String s) {
//        int left = 0, right = 0;
//        while (right < s.length()) {
//            char c = s.charAt(right);
//            // 更新滑动窗口
//            while (滑动窗口需要缩小) {
//                char d = s.charAt(left);
//                left++;
//                // 更新滑动窗口
//            }
//            right++;
//        }
//    }
}
