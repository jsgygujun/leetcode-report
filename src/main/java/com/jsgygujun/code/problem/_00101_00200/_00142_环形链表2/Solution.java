package com.jsgygujun.code.problem._00101_00200._00142_环形链表2;

import com.jsgygujun.code.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II
 *
 * 题目：
 * 给定一个链表，返回链表开始入环的第一个节点。如果链表无环，则返回null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。
 * 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 *
 * 进阶：
 * 你是否可以使用 O(1) 空间解决此题？
 *
 * @author GuJun
 * @date 2020/12/27
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) return head;
            head = head.next;
        }
        return null;
    }

    // 1. 找到快慢指针相遇节点
    // 2. 一个指针从head触发，一个指针从相遇节点触发，他们必定相遇在环的入口
    public ListNode detectCycle2(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                hasCycle = true;
                break;
            }
        }
        if (hasCycle) {
            ListNode curr = head;
            while (curr != null && slow != null) {
                if (curr == slow) return curr;
                curr = curr.next;
                slow = slow.next;
            }
        }
        return null;
    }
}
