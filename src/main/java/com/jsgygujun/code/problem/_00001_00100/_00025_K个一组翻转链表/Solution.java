package com.jsgygujun.code.problem._00001_00100._00025_K个一组翻转链表;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

/**
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每「k」个节点一组进行翻转，请你返回翻转后的链表。
 * k是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是「k」的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例：
 *
 * 给你这个链表：1->2->3->4->5
 * 当k= 2 时，应当返回: 2->1->4->3->5
 * 当k= 3 时，应当返回: 3->2->1->4->5
 *
 * 说明：
 * 你的算法只能使用常数的额外空间。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 *
 * @author GuJun
 * @date 2020/12/20
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        /**
         * 思路：
         * 1. 链表分为已翻转、待翻转和未翻转部份。
         * 2. [head,prev]：已翻转，[prev.next, tail]：待翻转，[tail.next, null]：未翻转
         * 3. 辅助函数 reverse(ListNode node): 翻转[node,null] 节点
         */
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;  // prev 指向每次要翻转的链表的头节点的上一个节点
        ListNode tail;          // tail 指向每次要翻转的链表的尾节点
        while (prev.next != null) {
            // 检查剩下的节点是否需要翻转（翻转条件，剩余节点个数>k）
            tail = prev;
            for (int i = 0; i < k && tail != null; ++i) {
                tail = tail.next;
            }
            if (tail == null) break; // 剩下的节点不足k个，不需要翻转
            //先记录下tail.next,方便后面链接链表
            ListNode next = tail.next;
            // 断开链表
            tail.next = null;
            // 记录下要翻转链表的头节点
            ListNode start = prev.next;
            // 翻转节点(prev.next, ..., tail) 翻转链表,prev.next指向翻转后的链表。1->2 变成2->1。 dummy->2->1
            prev.next = reverseList(start);
            // 翻转后头节点变到最后。通过.next把断开的链表重新链接。
            start.next = next;
            // 将prev换成下次要翻转的链表的头结点的上一个节点。即start
            prev = start; // 下一个要翻转的前驱节点
        }
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    @Test
    public void test() {
        ListNode list = new ListNode(new int[] {1,2,3,4,5});
        System.out.println(new Solution().reverseKGroup(list, 2));
    }

    @Test
    public void test2() {
        ListNode list = new ListNode(new int[] {1,2,3,4,5});
        System.out.println(new Solution().reverseKGroup(list, 3));
    }
}
