# 00144 二叉树的前序遍历

# 题目

给定一个二叉树，返回它的 前序 遍历。

示例:

```
输入: [1,null,2,3]  
   1
    \
     2
    /
   3 

输出: [1,2,3]
```


进阶: 递归算法很简单，你可以通过迭代算法完成吗？

# 思路

- 递归
- 迭代（颜色标记迭代法）

# 解法

- 解法一： 递归

  ```java
  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> res = new ArrayList<>();
    preorderHelper(root, res);
    return res;
  }
  private void preorderHelper(TreeNode root, List<Integer> res) {
    if (root == null) return;
    res.add(root.val);
    preorderHelper(root.left, res);
    preorderHelper(root.right, res);
  }
  ```

- Ç

  ```java
  // 节点颜色
  private enum NodeColor {WHITE, GRAY}
  // 彩色节点
  private static class ColorNode {
    final private NodeColor color;
    final private TreeNode node;
    private ColorNode(NodeColor color, TreeNode node) {
      this.color = color;
      this.node = node;
    }
  }
  // 颜色标记法二叉树前序遍历
  public List<Integer> preorderTraversal2(TreeNode root) {
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
        stack.push(new ColorNode(NodeColor.WHITE, node.right)); // 右
        stack.push(new ColorNode(NodeColor.WHITE, node.left)); // 左
        stack.push(new ColorNode(NodeColor.GRAY, node)); // 中
      } else {
        res.add(node.val);
      }
    }
    return res;
  }
  ```

  

