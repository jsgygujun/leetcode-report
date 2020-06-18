package com.jsgygujun.code.template.binary_tree;

import com.jsgygujun.code.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gujun@qiyi.com
 * @since 2020/6/18 10:05 上午
 */
public class Traversal {
    // 前序遍历
    public List<Integer> preorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderHelper(root, res);
        return res;
    }
    private void preorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorderHelper(root.left, res);
        preorderHelper(root.right, res);
    }

    // 中序遍历
    public List<Integer> inorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorderHelper(root, res);
        return res;
    }
    private void inorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderHelper(root.left, res);
        res.add(root.val);
        inorderHelper(root.right, res);
    }

    // 后续遍历
    public List<Integer> postorder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderHelper(root, res);
        return res;
    }
    private void postorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorderHelper(root.left, res);
        postorderHelper(root.right, res);
        res.add(root.val);
    }
}
