package com.jsgygujun.code.problem._00101_00200._00148_排序链表;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

/**
 * 148. 排序链表
 *
 * 题目：
 * 给你链表的头结点「head」，请将其按「升序」排列并返回排序后的链表 。
 *
 * 进阶：
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *
 * @author GuJun
 * @date 2020/12/12
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    // 归并排序
    // 1. 找到链表的中点，以中点为分界，将链表拆分成两个子链表。寻找链表的中点可以使用「快慢指针」的做法，快指针每次移动「2」步，慢指针每次移动「1」步，当快指针到达链表末尾时，慢指针指向的链表节点即为链表的中点。
    // 2. 对两个子链表分别排序
    // 3. 将两个排序后的子链表合并，得到完整的排序后的链表。可以使用「21. 合并两个有序链表」的做法，将两个有序的子链表进行合并。
    // 采用递归实现，递归的的终止条件是链表的节点个数小于或等于1，即当链表为空或者链表只包含一个节点时，不需要对链表进行拆分和排序。
    private ListNode sortList(ListNode head, ListNode tail) {
        // 链表为空
        if (head == null) return head;
        // 链表只包含一个节点
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        // 其他情况，寻找链表的中点，以中点为界，将链表拆分成两个链表。
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) fast = fast.next;
        }
        ListNode mid = slow;
        ListNode l = sortList(head, mid);
        ListNode r = sortList(mid, tail);
        return merge(l, r);
    }

    // 合并两个有序链表
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null || l2 != null) {
            int v1 = l1 == null ? Integer.MAX_VALUE : l1.val;
            int v2 = l2 == null ? Integer.MAX_VALUE : l2.val;
            if (v1 <= v2) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    @Test
    public void test_1() {
        ListNode l = new ListNode(new int[]{4,2,1,3});
        ListNode ans = new Solution().sortList(l);
        System.out.println(ans);
    }

    @Test
    public void test_2() {
        ListNode l = new ListNode(new int[]{-1, 5, 3, 4, 0});
        ListNode ans = new Solution().sortList(l);
        System.out.println(ans);
    }

}
