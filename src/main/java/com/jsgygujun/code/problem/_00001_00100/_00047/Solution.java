package com.jsgygujun.code.problem._00001_00100._00047;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * 题目：
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 */
public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        List<List<Integer>> ans = new ArrayList<>();
        dfs(nums, 0, used, new LinkedList<>(), ans);
        return ans;
    }

    private void dfs(int[] nums, int pos, boolean[] used, LinkedList<Integer> curr, List<List<Integer>> ans) {
        if (pos == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < used.length; ++i) {
            if (!used[i]) {
                // 剪枝叶。i > 0 是为了保证 nums[i - 1] 有意义；写 !used[i - 1] 是因为 nums[i - 1] 在深度优先遍历的过程中刚刚被撤销选择
                if (i > 0 && nums[i-1] == nums[i] && !used[i-1]) continue;
                used[i] = true;
                curr.add(nums[i]);
                dfs(nums, pos+1, used, curr, ans);
                curr.pollLast();
                used[i] = false;
            }
        }
    }

    @Test
    public void test() {
        System.out.println(new Solution().permuteUnique(new int[]{1,1,2}));
        System.out.println(new Solution().permuteUnique(new int[]{}));
    }
}
