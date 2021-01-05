package com.jsgygujun.code.problem._00001_00100._00017_电话号码的字母组合;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 * 示例:
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 *
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
public class Solution {

    private final Map<Character, char[]> dict = new HashMap<Character, char[]>() {
        {
            put('2', new char[]{'a', 'b', 'c'});
            put('3', new char[]{'d', 'e', 'f'});
            put('4', new char[]{'g', 'h', 'i'});
            put('5', new char[]{'j', 'k', 'l'});
            put('6', new char[]{'m', 'n', 'o'});
            put('7', new char[]{'p', 'q', 'r', 's'});
            put('8', new char[]{'t', 'u', 'v'});
            put('9', new char[]{'w', 'x', 'y', 'z'});
        }
    };

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.isEmpty()) return ans;
        dfs(digits, 0, "", ans);
        return ans;
    }

    private void dfs(String digits, int pos, String cur, List<String> ans) {
        if (pos == digits.length()) {
            ans.add(cur);
            return;
        }
        for (char c : dict.get(digits.charAt(pos))) {
            dfs(digits, pos+1, cur + c, ans);
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations("2"));
    }

}
