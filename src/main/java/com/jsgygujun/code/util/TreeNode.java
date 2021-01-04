package com.jsgygujun.code.util;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode(int x) { val = x; }


    // 优先访问根结点，然后再分别访问左孩子和右孩子
    // 对于任一节点p:
    // 1. 访问节点p，并将p入栈;
    // 2. 判断节点p的左孩子是否为null
    //    若p.left != null, 则将p的左孩子设置为当前节点p。
    //    若p.left == null, 则取栈顶节点并执行出栈操作，并将栈顶节点的右孩子设置为当前节点p，循环至1；
    // 3. 知道p为null且栈为空，遍历结束。
    static void preorder(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                System.out.println(p.val);
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    static void inorder(TreeNode root) {
        if (root == null) return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            if (!stack.isEmpty()) {
                p = stack.pop();
                System.out.println(p.val);
                p = p.right;
            }
        }
    }

    /**
     *                 5
     *               |   \
     *              2     4
     *             | \   |  \
     *            1   3  7   6
     *
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
//        preorder(root);
        inorder(root);
    }
}


