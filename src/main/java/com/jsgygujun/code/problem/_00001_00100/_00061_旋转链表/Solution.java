package com.jsgygujun.code.problem._00001_00100._00061_旋转链表;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

/**
 * 61. 旋转链表
 *
 * 题目：
 * 给定一个链表，旋转链表，将链表每个节点向右移动「k」个位置，其中「k」是非负数。
 *
 * 示例1：
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例2：
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * @author GuJun
 * @date 2020/12/20
 */
public class Solution {
    // 1. 求出链表节点数n
    // 2. k = k % n;
    // 3. 找出倒数第k+1个节点node
    // 4. dummy.next = node.next; node.next.next = head; node.next = NULL;
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        int len = 0;
        ListNode curr = head;
        while (curr != null) {
            len++;
            curr = curr.next;
        }
        k = k % len;
        if (k == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = head, slow = head;
        for (int i = 0; i < k; ++i) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        dummy.next = slow.next;
        slow.next = null;
        fast.next = head;
        return dummy.next;
    }

    @Test
    public void test() {
        ListNode list = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(new Solution().rotateRight(list, 2));
    }

    @Test
    public void test2() {
        ListNode list = new ListNode(new int[]{0, 1, 2});
        System.out.println(new Solution().rotateRight(list, 3));
    }

    @Test
    public void test3() {
        ListNode list = new ListNode(new int[]{0, 1, 2});
        System.out.println(new Solution().rotateRight(list, 2));
    }
}
