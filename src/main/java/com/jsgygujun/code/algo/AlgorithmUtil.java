package com.jsgygujun.code.algo;

import com.jsgygujun.code.util.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @author GuJun
 * @date 2021/1/9
 */
public class AlgorithmUtil {

    // 199. 二叉树的右视图
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root == null) return ans;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> vals = new ArrayList<>();
            for (int i = 0; i < len; ++i) {
                TreeNode node = queue.poll();
                vals.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(vals);
        }
        for (int i = 0; i < res.size(); ++i) {
            List<Integer> vals = res.get(i);
            ans.add(vals.get(vals.size()-1));
        }
        return ans;
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < size; ++i) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            ans.add(res);
        }
        for (int i = 0; i < ans.size(); ++i) {
            if (i % 2 == 1) {
                Collections.reverse(ans.get(i));
            }
        }
        return ans;
    }

    @Test
    public void test() {

    }
}
