package com.jsgygujun.code.problem._00001_00100._00094;

import com.jsgygujun.code.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    // 递归遍历
    private void inorderHelper(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorderHelper(root.left, res);
        res.add(root.val);
        inorderHelper(root.right, res);
    }

    // 节点颜色
    private enum NodeColor {WHITE, GRAY}
    // 彩色节点
    private static class ColorNode {
        private final NodeColor color;
        private final TreeNode node;
        private ColorNode(NodeColor color, TreeNode node) {
            this.color = color;
            this.node = node;
        }
    }
    // 颜色标记法
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<ColorNode> stack = new Stack<>();
        if (root == null) return res;
        stack.push(new ColorNode(NodeColor.WHITE, root));
        while (!stack.isEmpty()) {
            ColorNode colorNode = stack.pop();
            NodeColor color = colorNode.color;
            TreeNode node = colorNode.node;
            if (node == null) continue;
            if (color == NodeColor.WHITE) {
                stack.push(new ColorNode(NodeColor.WHITE, node.right)); // 右
                stack.push(new ColorNode(NodeColor.GRAY, node)); // 中
                stack.push(new ColorNode(NodeColor.WHITE, node.left)); // 左
            } else {
                res.add(node.val);
            }
        }
        return res;
    }
}
