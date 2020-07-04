package com.jsgygujun.code.problem._00461;

public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y, res = 0;
        while (xor != 0) {
            res += (xor & 1);
            xor >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingDistance(1, 4));
    }
}
