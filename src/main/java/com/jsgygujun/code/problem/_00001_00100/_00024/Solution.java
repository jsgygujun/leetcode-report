package com.jsgygujun.code.problem._00001_00100._00024;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

/**
 * 24. 两两交换链表中的节点
 *
 * 题目：
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例:
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode curr = prev.next;
            ListNode next = curr.next;
            // -> prev -> curr -> next -> next.next , swap(curr, next)
            // swap(curr, next), and then prev = curr
            prev.next = next;
            curr.next = next.next;
            next.next = curr;
            prev = curr;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        System.out.println(new Solution().swapPairs(new ListNode(new int[]{1,2,3,4})));
    }
}
