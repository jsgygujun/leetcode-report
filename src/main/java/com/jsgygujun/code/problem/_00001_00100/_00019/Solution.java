package com.jsgygujun.code.problem._00001_00100._00019;

import com.jsgygujun.code.util.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0); // 哑节点：避开对头节点删除时的特殊处理
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        // 快指针先走N+1步，使得快慢指针中间间隔N个节点
        for (int i = 0; i < n+1; ++i) {
            fast = fast.next;
        }
        // 快慢指针同时走
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // 此时fast==null
        // 删除slow.next节点
        slow.next = slow.next.next;
        return dummy.next;
    }
}
