package com.jsgygujun.code.problem._00101_00200._00103;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 103. 二叉树的锯齿形层次遍历
 *
 * 题目：
 * 给定一个二叉树，返回其节点值的锯齿形层次遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层次遍历如下：
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        bfs(root, ans);
        for (int i = 0; i < ans.size(); ++i) {
            if (i % 2 == 1) {
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }

    private void bfs(TreeNode root, List<List<Integer>> nums) {
        if (root == null) return;
        List<TreeNode> curr = new ArrayList<>();
        List<TreeNode> next = new ArrayList<>();
        curr.add(root);
        while (!curr.isEmpty()) {
            List<Integer> arr = new ArrayList<>();
            for (TreeNode node : curr) {
                arr.add(node.val);
                if (node.left != null) next.add(node.left);
                if (node.right != null) next.add(node.right);
            }
            nums.add(arr);
            curr = next;
            next = new ArrayList<>();
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(new Solution().zigzagLevelOrder(root));
    }

}
