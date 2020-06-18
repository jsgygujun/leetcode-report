# 二叉树模版

## 递归遍历模版

递归遍历比较简单，模版如下：

```java
void traversal(TreeNode root, List<Interger> res) {
  if (root == null) return;
  // res.add(root.val);
  traversal(root.left, res);
  // res.add(root.val);
  traversal(root.right, res);
  // res.add(root.val)
}
```



## 迭代遍历模版

颜色标记法迭代遍历二叉树，核心思想：

- 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
- 如果遇到的节点为白色，则将其标记为灰色，然后将其自身（灰色），左右节点（白色）按照前序，中序，后序**反向**入栈。
- 如果遇到的节点为灰色，则将节点值输出。

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
// 前序遍历
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
// 中序遍历
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
// 后序遍历
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
```




