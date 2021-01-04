package com.jsgygujun.code.problem._00001_00100._00100_相同的树;

import com.jsgygujun.code.util.TreeNode;

/**
 * 100. 相同的树
 *
 * 给定两个二叉树，编写一个函数来检验它们是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // 前序遍历。当前节点，当前节点左子树，当前节点右子树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false; // 其中又一个为null，另一个不为null
        if (p.val != q.val) return false; // 值不相同
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
