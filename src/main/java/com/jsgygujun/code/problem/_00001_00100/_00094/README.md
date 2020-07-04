# 00094 二叉树的中序遍历

## 题目

给定一个二叉树，返回它的*中序* 遍历。

示例：

```
输入: [1,null,2,3]
   1
    \
     2
    /
   3

输出: [1,3,2]
```

**进阶:** 递归算法很简单，你可以通过迭代算法完成吗？

## 思路

* 递归
* 迭代（颜色标记迭代法）

## 解法

* 解法一： 递归

  ```java
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
  ```

* 解法二： 颜色标记迭代法

  ```java
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
  ```

  



