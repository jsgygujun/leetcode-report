package com.jsgygujun.code.problem._00001_00100._00022_括号生成;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        dfs("", ans, n, 0, 0);
        return ans;
    }

    public void dfs(String curr, List<String> ans, int n, int l, int r) {
        if (curr.length() == n*2) {
            ans.add(curr);
            return;
        }
        if (l < n) dfs(curr+"(", ans, n, l+1, r); // 放左括号的条件： 左括号的个数<N
        if (r < l) dfs(curr+")", ans, n, l, r+1); // 放有括号的条件： 右括号的个数小于左括号的个数
    }

    @Test
    public void test() {
        System.out.println(new Solution().generateParenthesis(3));
        System.out.println(new Solution().generateParenthesis(1));
        System.out.println(new Solution().generateParenthesis(0));
    }
}
