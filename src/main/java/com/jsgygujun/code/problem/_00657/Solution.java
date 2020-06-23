package com.jsgygujun.code.problem._00657;

public class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); ++i) {
            switch (moves.charAt(i)) {
                case 'L':
                    x--;
                    break;
                case 'R':
                    x++;
                    break;
                case 'U':
                    y++;
                    break;
                case 'D':
                    y--;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().judgeCircle("DU"));
        System.out.println(new Solution().judgeCircle("LL"));
    }
}
