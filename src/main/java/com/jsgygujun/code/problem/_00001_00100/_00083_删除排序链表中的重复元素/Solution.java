package com.jsgygujun.code.problem._00001_00100._00083_删除排序链表中的重复元素;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

/**
 * 83. 删除排序链表中的重复元素
 *
 * 给定一个「排序」链表，删除所有重复的元素，使得每个元素只出现一次。
 *
 * 示例 1:
 * 输入: 1->1->2
 * 输出: 1->2
 *
 * 示例 2:
 * 输入: 1->1->2->3->3
 * 输出: 1->2->3
 *
 * @author GuJun
 * @date 2020/12/20
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        // prev 与 curr 为相邻的两个节点
        ListNode prev = head;
        ListNode curr = head.next;
        while (curr != null) {
            if (prev.val == curr.val) {
                // 相邻的两个节点的值一样
                // remove curr node.
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return head;
    }

    @Test
    public void test() {
        ListNode list = new ListNode(new int[]{1,1,2});
        System.out.println(new Solution().deleteDuplicates(list));
    }

    @Test
    public void test_2() {
        ListNode list = new ListNode(new int[]{1,1,2,3,3});
        System.out.println(new Solution().deleteDuplicates(list));
    }
}
