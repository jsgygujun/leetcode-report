package com.jsgygujun.code.problem._00201_00300._00206_反转链表;

import com.jsgygujun.code.util.ListNode;

/**
 * @author GuJun
 * @date 2020/12/20
 */
public class Solution {
    // 双指针
    // 定义两个指针「prev」、「curr」， 「prev」 在前， 「curr」 在后
    // 每次让「curr」的 next 指向 prev，实现一次局部反转
    // 局部反转完成之后，prev 和 curr 同时向前移动一个位置
    // 循环上述过程，知道 prev 到达链表尾部
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next; // 记录当前节点的下一个节点
            curr.next = prev; // 当前节点指向prev
            // prev 和 curr 节点都前进一步
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
