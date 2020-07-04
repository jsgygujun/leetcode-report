package com.jsgygujun.code.problem._00002;

import com.jsgygujun.code.util.ListNode;

import java.sql.SQLOutput;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p = dummy;
        int carry = 0;
        while (p1 != null || p2 != null) {
            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;
            int sum = v1 + v2 + carry;
            p.next = new ListNode(sum % 10);
            carry = sum / 10;
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
            p = p.next;
        }
        if (carry != 0) p.next = new ListNode(1);
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(new int[]{2,4,3});
        ListNode l2 = new ListNode(new int[]{5,6,4});
        System.out.println(new Solution().addTwoNumbers(l1, l2));

        System.out.println(new Solution().addTwoNumbers(new ListNode(new int[]{5}), new ListNode(new int[]{5})));
    }
}
