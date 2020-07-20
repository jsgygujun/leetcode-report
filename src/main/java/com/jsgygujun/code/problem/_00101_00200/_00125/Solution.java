package com.jsgygujun.code.problem._00101_00200._00125;

/**
 * @author gujun@qiyi.com
 * @since 2020/6/19 1:08 下午
 */
public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) return true;
        for (int i = 0, j = s.length()-1; i < j; ++i, --j) {
            while (!Character.isLetterOrDigit(s.charAt(i)) && i < j) ++i;
            while (!Character.isLetterOrDigit(s.charAt(j)) && i < j) --j;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sol.isPalindrome("race a car"));
    }
}
