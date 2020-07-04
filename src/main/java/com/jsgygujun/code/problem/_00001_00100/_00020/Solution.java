package com.jsgygujun.code.problem._00020;

import java.util.*;

/**
 * 20-有效的括号
 *
 * 题目：
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 *
 * 示例1：
 * 输入: "()"
 * 输出: true
 *
 * 示例2：
 * 输入: "()[]{}"
 * 输出: true
 *
 * 示例3：
 * 输入: "(]"
 * 输出: false
 *
 * 示例4：
 * 输入: "([)]"
 * 输出: false
 *
 * 示例5：
 * 输入: "{[]}"
 * 输出: true
 */
public class Solution {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) return true;
        Map<Character, Character> map = new HashMap<>(3);
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Deque<Character> stack = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || !map.get(stack.pop()).equals(c)) return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
        System.out.println(new Solution().isValid("["));
        System.out.println(new Solution().isValid("]"));
    }
}
