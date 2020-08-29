package com.jsgygujun.code.problem._00001_00100._00019;

import com.jsgygujun.code.util.ListNode;


/**
 * 19. 删除链表的倒数第N个节点
 *
 * 题目：
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 说明：
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 * 你能尝试使用一趟扫描实现吗？
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /*
         * - 快慢指针
         * 快指针从链表头向前移动`n+1`步，慢指针从链表头出发。同时移动快慢指针，当快指针到达最后一个节点时，则当慢指针的删除其next节点。
         */
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
