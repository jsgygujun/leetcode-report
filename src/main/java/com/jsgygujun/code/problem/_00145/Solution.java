package com.jsgygujun.code.problem._00145;

import com.jsgygujun.code.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gujun@qiyi.com
 * @since 2020/6/18 10:20 上午
 */
public class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
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
