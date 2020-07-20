package com.jsgygujun.code.problem._00101_00200._00102;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 102-二叉树的层序遍历
 *
 * 题目：
 * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 *
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其层次遍历结果：
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        levelOrder(root, 1, ans);
        return ans;
    }

    private void levelOrder(TreeNode root, int depth, List<List<Integer>> ans) {
        if (root == null) return;
        if (depth > ans.size()) ans.add(new ArrayList<>());
        ans.get(depth-1).add(root.val);
        levelOrder(root.left, depth+1, ans);
        levelOrder(root.right, depth+1, ans);
    }


    @Test
    public void test_1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(levelOrder(root));
    }
}
