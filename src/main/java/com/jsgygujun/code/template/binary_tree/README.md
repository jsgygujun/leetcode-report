# 二叉树模版

## 非递归遍历模版

颜色标记法遍历二叉树，核心思想：

- 使用颜色标记节点的状态，新节点为白色，已访问的节点为灰色。
- 如果遇到的节点为白色，则将其标记为灰色，然后将其标记为灰色，然后将其自身，左右节点按照前序，中序，后序**反向**入栈。
- 如果遇到的节点为灰色，则将节点值输出。

