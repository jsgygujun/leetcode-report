package com.jsgygujun.code.problem._00001_00100._00098_验证二叉搜索树;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 98. 验证「二叉搜索树」
 *
 * 题目：
 * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 *
 * 假设一个二叉搜索树具有如下特征：
 *   1. 节点的左子树只包含小于当前节点的数。
 *   2. 节点的右子树只包含大于当前节点的数。
 *   3. 所有左子树和右子树自身必须也是二叉搜索树。
 *
 * 示例 1:
 * 输入:
 *     2
 *    / \
 *   1   3
 * 输出: true
 *
 * 示例2：
 * 输入:
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 * 输出: false
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *     根节点的值为 5 ，但是其右子节点值为 4 。
 *
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        // 当前节点的情况
        // 左右子树的情况
        if (root == null) return true;
        if (root.left != null && maxValue(root.left) >= root.val) return false; // 左边有节点的值大于根节点
        if (root.right != null && minValue(root.right) <= root.val) return false; // 右边有节点的值小于根节点
        return isValidBST(root.left) && isValidBST(root.right);
    }

    // 中序遍历
    public boolean isValidBST2(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        for (int i = 1; i < nums.size(); ++i) {
            if (nums.get(i) <= nums.get(i-1)) return false;
        }
        return true;
    }

    public int maxValue(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        int val = root.val;
        int left = maxValue(root.left);
        int right = maxValue(root.right);
        return Math.max(val, Math.max(left, right));
    }

    public int minValue(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        int val = root.val;
        int left = minValue(root.left);
        int right = minValue(root.right);
        return Math.min(val, Math.min(left, right));
    }

    public void inorder(TreeNode root, List<Integer> nums) {
        if (root == null) return;
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    private TreeNode case1;
    private TreeNode case2;
    private TreeNode case3;

    @Before
    public void setUp() {
        case1 = new TreeNode(2);
        case1.left = new TreeNode(1);
        case1.right = new TreeNode(3);

        case2 = new TreeNode(5);
        case2.left = new TreeNode(1);
        case2.right = new TreeNode(4);
        case2.right.left = new TreeNode(3);
        case2.right.right = new TreeNode(6);

        case3 = new TreeNode(10);
        case3.left = new TreeNode(5);
        case3.right = new TreeNode(15);
        case3.right.left = new TreeNode(6);
        case3.right.right = new TreeNode(20);
    }

    @Test
    public void test() {
        Assert.assertTrue(new Solution().isValidBST2(case1));
        Assert.assertFalse(new Solution().isValidBST2(case2));
    }

    @Test
    public void test2() {
        Assert.assertFalse(new Solution().isValidBST2(case3));
    }
}
