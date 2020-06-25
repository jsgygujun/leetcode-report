package com.jsgygujun.code.problem._00455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int res = 0;
        int i = g.length-1, j = s.length-1;
        while (i >= 0 && j >= 0) {
            if (g[i] <= s[j]) {
                --j;
                ++res;
            }
            --i;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findContentChildren(new int[]{1,2,3}, new int[]{1,1}));
        System.out.println(new Solution().findContentChildren(new int[]{1,2}, new int[]{1,2,3}));
    }
}
