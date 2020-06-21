package com.jsgygujun.code.problem._00007;

public class Solution {
    public int reverse(int x) {
        int sign = x >= 0 ? 1 : -1;
        int res = 0;
        x = Math.abs(x);
        while (x > 0) {
            int r = x % 10;
            // 溢出条件，其中7是2^32-1的个位
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && r > 7)) return 0;
            res = res * 10 + r;
            x /= 10;
        }
        return sign * res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
    }
}
