package com.jsgygujun.code.problem._00001_00100._00046;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * 题目：
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 *
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, used, 0, new LinkedList<Integer>(), ans);
        return ans;
    }

    private void dfs(int[] nums, boolean[] used, int pos, LinkedList<Integer> path, List<List<Integer>> ans) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < used.length; ++i) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i]= true;
                dfs(nums, used, pos+1, path, ans);
                used[i] = false;
                path.pollLast();
            }
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().permute(new int[]{1,2,3,4}));
        System.out.println(new Solution().permute(new int[]{1,2,3}));
    }
}
