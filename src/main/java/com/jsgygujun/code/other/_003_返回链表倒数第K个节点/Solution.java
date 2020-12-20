package com.jsgygujun.code.other._003_返回链表倒数第K个节点;

import com.jsgygujun.code.util.ListNode;

/**
 * @author GuJun
 * @date 2020/12/20
 */
public class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        // 快指针先走「k」步骤
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时 fast=null，slow 与 fast 距离 k 个节点
        return slow.val;
    }
}
