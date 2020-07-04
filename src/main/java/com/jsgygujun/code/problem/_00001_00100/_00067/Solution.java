package com.jsgygujun.code.problem._00067;

public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, x, y, length = Math.max(a.length(), b.length());
        for (int i = 0; i < length; ++i) {
            x = i >= a.length() ? 0 : Integer.parseInt(a.substring(a.length()-i-1, a.length()-i));
            y = i >= b.length() ? 0 : Integer.parseInt(b.substring(b.length()-i-1, b.length()-i));
            sb.append((x+y+carry) % 2);
            carry = (x + y + carry) / 2;
        }
        if (carry > 0) sb.append(carry);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().addBinary("11", "1"));
        System.out.println(new Solution().addBinary("1010", "1011"));
    }
}
