package com.jsgygujun.code.problem._00101_00200._00200_岛屿数量;

import org.junit.Test;

/**
 * @author GuJun
 * @date 2021/1/20
 */
public class Solution {
    private char[][] grid;
    private int rowNum;
    private int colNum;
    private boolean[][] visited;

    private static final int[][] dirs = new int[][] {
            {0, 1},
            {1, 0},
            {-1, 0},
            {0, -1}
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        this.grid = grid;
        rowNum = grid.length;
        colNum = grid[0].length;
        visited = new boolean[rowNum][colNum];
        int ans = 0;
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < colNum; ++j) {
                if (grid[i][j] == '0') continue;
                if (visited[i][j]) continue;
                dfs(i, j);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(int i, int j) {
        if (grid[i][j] == '0') return;
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (!valid(x, y)) continue;
            if (visited[x][y]) continue;
            dfs(x, y);
        }
    }

    private boolean valid(int i, int j) {
        return i >= 0 && i < rowNum && j >= 0 && j < colNum;
    }

    @Test
    public void test() {
        char[][] grid = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new Solution().numIslands(grid));
    }
}
