package com.jsgygujun.code.problem._00104;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * 104-二叉树的最大深度
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    @Test
    public void test_1() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Assert.assertEquals(3, new Solution().maxDepth(root));
    }
}
