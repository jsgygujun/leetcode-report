package com.jsgygujun.code.problem._00101_00200._00113_二叉树_根到叶子节点路径和等于目标值;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author GuJun
 * @date 2021/1/9
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>(); // 保存路径
        dfs(root, sum, ans, path);
        return ans;
    }

    private void dfs(TreeNode root, int sum, List<List<Integer>> ans, LinkedList<Integer> path) {
        if (root == null) return;
        sum -= root.val;
        path.addLast(root.val);
        if (root.left == null && root.right == null && sum == 0) {
            // 叶子节点，且路径和等于目标值
            ans.add(new ArrayList<>(path));
        }
        dfs(root.left, sum, ans, path);
        dfs(root.right, sum, ans, path);
        path.removeLast(); // 极其重要
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        System.out.println(new Solution().pathSum(root, 22));
    }



}
