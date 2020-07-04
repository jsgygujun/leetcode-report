package com.jsgygujun.code.problem.tree._00637;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 637. 二叉树的层平均值
 *
 * 示例1：
 * 输入：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 *
 */
public class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        List<List<Integer>> nums = new ArrayList<>();
        dfs(root, nums, 0);
        for (List<Integer> num : nums) {
            int sum = 0;
            for (int v : num) {
                sum += v;
            }
            ans.add((double) sum / num.size());
        }
        return ans;
    }

    // DFS 求解出每一层的数值， 前序遍历
    public void dfs(TreeNode root, List<List<Integer>> nums, int height) {
        if (root == null) return;
        if (nums.size() < height+1) {
            nums.add(new ArrayList<>());
        }
        nums.get(height).add(root.val);
        dfs(root.left, nums, height+1);
        dfs(root.right, nums, height+1);
    }

    // BFS 解法
    public void bfs(TreeNode root, List<Double> ans) {
        List<TreeNode> curr = new ArrayList<>(); // 当前层需要处理的
        curr.add(root);
        while (!curr.isEmpty()) {
            int sum = 0;
            List<TreeNode> next = new ArrayList<>(); // 下一层需要处理的
            for (TreeNode node : curr) {
                sum += node.val;
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            ans.add((double)sum / curr.size());
            curr.clear();
            curr = next;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> nums = new ArrayList<>();
        dfs(root, nums, 0);
        System.out.println(nums);

        System.out.println(new Solution().averageOfLevels(root));
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<Double> ans = new ArrayList<>();
        bfs(root, ans);
        System.out.println(ans);
    }
}
