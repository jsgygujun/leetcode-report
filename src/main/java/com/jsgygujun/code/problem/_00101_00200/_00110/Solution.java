package com.jsgygujun.code.problem._00101_00200._00110;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * 110. 平衡二叉树
 *
 * 题目：
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 *
 * 本题中，一棵高度平衡二叉树定义为：
 *
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
 *
 * 示例 1:
 * 给定二叉树 [3,9,20,null,null,15,7]
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回 true 。
 *
 * 示例2：
 * 给定二叉树 [1,2,2,3,3,null,null,4,4]
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 *
 */
public class Solution {

    // O(nlogn)
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    // O(n)
    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // 在计算二叉树高度的时候，如果不平衡则返回-2
    public int height2(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = height2(root.left);
        int rightHeight = height2(root.right);
        if (leftHeight == -2 || rightHeight == -2) return -2;
        if (Math.abs(leftHeight-rightHeight) > 1) return -2;
        return Math.max(leftHeight, rightHeight) + 1;
    }

    private TreeNode case1;
    private TreeNode case2;

    @Before
    public void setUp() {
        case1 = new TreeNode(3);
        case1.left = new TreeNode(9);
        case1.right = new TreeNode(20);
        case1.right.left = new TreeNode(15);
        case1.right.right = new TreeNode(7);

        case2 = new TreeNode(1);
        case2.left = new TreeNode(2);
        case2.right = new TreeNode(2);
        case2.left.left = new TreeNode(3);
        case2.left.right = new TreeNode(3);
        case2.left.left.left = new TreeNode(4);
        case2.left.left.right = new TreeNode(4);
    }

    @Test
    public void test() {
        Assert.assertTrue(new Solution().isBalanced(case1));
    }

    @Test
    public void test2() {
        Assert.assertFalse(new Solution().isBalanced(case2));
    }

    @Test
    public void test3() {
        Assert.assertEquals(3, height2(case1));
        Assert.assertEquals(-2, height2(case2));
    }

}
