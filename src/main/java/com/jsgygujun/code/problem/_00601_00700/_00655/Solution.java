package com.jsgygujun.code.problem._00601_00700._00655;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 655. 输出二叉树
 * 在一个 m*n 的二维字符串数组中输出二叉树，并遵守以下规则：
 *
 * 行数 m 应当等于给定二叉树的高度。
 * 列数 n 应当总是奇数。
 * 根节点的值（以字符串格式给出）应当放在可放置的第一行正中间。根节点所在的行与列会将剩余空间划分为两部分（左下部分和右下部分）。你应该将左子树输出在左下部分，右子树输出在右下部分。左下和右下部分应当有相同的大小。即使一个子树为空而另一个非空，你不需要为空的子树输出任何东西，但仍需要为另一个子树留出足够的空间。然而，如果两个子树都为空则不需要为它们留出任何空间。
 * 每个未使用的空间应包含一个空的字符串""。
 * 使用相同的规则输出子树。
 *
 * 示例1：
 * 输入:
 *      1
 *     /
 *    2
 * 输出:
 * [["", "1", ""],
 *  ["2", "", ""]]
 *
 * 示例2：
 * 输入:
 *      1
 *     / \
 *    2   3
 *     \
 *      4
 * 输出:
 * [["", "", "", "1", "", "", ""],
 *  ["", "2", "", "", "", "3", ""],
 *  ["", "", "4", "", "", "", ""]]
 *
 * 示例3：
 * 输入:
 *       1
 *      / \
 *     2   5
 *    /
 *   3
 *  /
 * 4
 * 输出:
 * [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
 *  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
 *  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
 *  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
 *
 *  注意: 二叉树的高度在范围 [1, 10] 中。
 */
public class Solution {
    public List<List<String>> printTree(TreeNode root) {
        // 求出二叉树的高度和宽度，height()
        // 二叉树第i层的节点个数： 2^i - 1
        // 递归填充
        int h = height(root);
        int w = (1 << h) - 1;
        List<List<String>> ans = new ArrayList<List<String>>(h);
        for (int i = 0; i < h; ++i) {
            List<String> l = new ArrayList<>(w);
            for (int j = 0; j < w; ++j) {
                l.add("");
            }
            ans.add(l);
        }
        fill(root, ans, 0, 0, w-1);
        return ans;
    }

    // 二叉树的高度
    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root.right)) + 1;
    }

    // 填节点的值， 二分的方法
    void fill(TreeNode root, List<List<String>> ans, int h, int l, int r) {
        if (root == null) return;
        // 在合适的位置填充根节点数值
        int mid = (l+r)/2;
        ans.get(h).set(mid, String.valueOf(root.val));
        // 递归填充左子树和右子树
        fill(root.left, ans, h+1, l, mid-1);
        fill(root.right, ans, h+1, mid+1, r);
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(0);
        Assert.assertEquals(1, height(root));

        root.left = new TreeNode(1);
        Assert.assertEquals(2, height(root));

        Assert.assertEquals(0, height(null));
    }


    @Test
    public void test_2() {
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);
        System.out.println(new Solution().printTree(root));
    }

}
