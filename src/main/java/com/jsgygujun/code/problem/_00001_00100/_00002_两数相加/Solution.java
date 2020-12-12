package com.jsgygujun.code.problem._00001_00100._00002_两数相加;

import com.jsgygujun.code.util.ListNode;

/**
 * 2. 两数相加
 *
 * 题目：
 * 给出两个「非空」的链表用来表示两个非负的整数。其中，它们各自的位数是按照「逆序」的方式存储的，并且它们的每个节点只能存储「一位」数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字「0」之外，这两个数都不会以「0」开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 注意使用虚拟节点。
        ListNode dummy = new ListNode(0);
        ListNode p1 = l1, p2 = l2, p = dummy; // p1,p2分别是链表1和链表2中当前正在处理的节点
        int carry = 0; // 进位
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
