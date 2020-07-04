package com.jsgygujun.code.problem._00404;

import com.jsgygujun.code.util.TreeNode;

/**
 * 404-左叶子之和
 *
 * 题目：
 * 计算给定二叉树的所有左叶子之和。
 *
 * 示例：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 在这个二叉树中，有两个左叶子，分别是 9 和 15，所以返回 24
 */
public class Solution {
    public int sumOfLeftLeaves(TreeNode root) {
        // 一、 终止条件
        //     1. 当前节点为NULL，return 0
        //     2. 当前节点的子树是一个leaf节点，sum = leaf.val
        // 二、 递归过程
        //     1. sum + 当前节点左子树左叶子节点之和+当前节点右子树左叶子节点之和。
        if (root == null) return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) sum += root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    /**
     * 求二叉树所有节点之和
     * @param root 根节点
     * @return 所有节点之和
     */
    public int sumOfNode(TreeNode root) {
        if (root == null) return 0;
        return root.val + sumOfNode(root.left) + sumOfNode(root.right);
    }

    /**
     * 求所有树叶子节点之和
     * @param root 根节点
     * @return 所有叶子节点之和
     */
    public int sumOfLeaves(TreeNode root) {
        if (root == null) return 0;
        int sum = 0;
        if (root.left == null && root.right == null) sum += root.val;
        return sum + sumOfLeaves(root.left) + sumOfLeaves(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().sumOfLeftLeaves(root));
    }
}
