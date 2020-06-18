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


