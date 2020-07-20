package com.jsgygujun.code.problem._00101_00200._00145;

import com.jsgygujun.code.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    // 递归遍历
    private void postorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        postorderHelper(root.left, res);
        postorderHelper(root.right, res);
        res.add(root.val);
    }

    // 节点颜色
    enum NodeColor {WHITE, GRAY}
    // 彩色节点
    private static class ColorNode {
        final private NodeColor color;
        final private TreeNode node;
        private ColorNode(NodeColor color, TreeNode node) {
            this.color = color;
            this.node = node;
        }
    }
    // 颜色标记法二叉树后续遍历
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Stack<ColorNode> stack = new Stack<>();
        stack.push(new ColorNode(NodeColor.WHITE, root));
        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            NodeColor color = colorNode.color;
            TreeNode node = colorNode.node;
            if (node == null) continue;
            if (color == NodeColor.WHITE) {
                stack.add(new ColorNode(NodeColor.GRAY, node)); // 中
                stack.add(new ColorNode(NodeColor.WHITE, node.right)); // 右
                stack.add(new ColorNode(NodeColor.WHITE, node.left)); // 左
            } else {
                res.add(node.val);
            }
        }
        return res;
    }
}
