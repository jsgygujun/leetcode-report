package com.jsgygujun.code.problem._00021;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

/**
 * 21-合并两个有序链表
 */
public class Solution {
    // 创建新的节点
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (v1 > v2) {
                curr.next = new ListNode(v2);
                l2 = l2.next;
            } else {
                curr.next = new ListNode(v1);
                l1 = l1.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    // 使用原来节点
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        if (l1 != null) curr.next = l1;
        if (l2 != null) curr.next = l2;
        return dummy.next;
    }

    @Test
    public void test_2() {
        Solution sol = new Solution();
        System.out.println(sol.mergeTwoLists(new ListNode(new int[]{1,2,4}), new ListNode(new int[]{1,3,4})));
    }
}
