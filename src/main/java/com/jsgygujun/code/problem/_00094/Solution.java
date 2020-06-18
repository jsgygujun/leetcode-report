package com.jsgygujun.code.problem._00094;

import com.jsgygujun.code.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gujun@qiyi.com
 * @since 2020/6/18 10:52 上午
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
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
}
