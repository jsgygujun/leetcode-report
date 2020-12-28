package com.jsgygujun.code.problem._00101_00200._00160_相交链表;

import com.jsgygujun.code.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 160. 相交链表
 *
 * 编写一个程序，找到两个单链表相交的起始节点。
 *
 * @Author GuJun
 * @Date 2020/12/28
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode curr = headA;
        while (curr != null) {
            set.add(curr);
            curr = curr.next;
        }
        curr = headB;
        while (curr != null) {
            if (set.contains(curr)) return curr;
            curr = curr.next;
        }
        return null;
    }
}
