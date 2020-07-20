package com.jsgygujun.code.problem._00001_00100._00023;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

/**
 * 23. 合并K个排序链表
 *
 * 题目：
 *
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 *
 * 示例:
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        ListNode[] c = new ListNode[lists.length];
        System.arraycopy(lists, 0, c, 0, lists.length);
        while (valid(c)) {
            int val = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < lists.length; ++i) {
                if (c[i] != null && c[i].val < val) {
                    val = c[i].val;
                    index = i;
                }
            }
            curr.next = c[index];
            c[index] = c[index].next;
            curr = curr.next;
        }
        return dummy.next;
    }

    boolean valid(ListNode[] lists) {
        for (int i = 0; i < lists.length; ++i) {
            if (lists[i] != null) return true;
        }
        return false;
    }

    @Test
    public void test() {
        ListNode l1 = new ListNode(new int[]{1,4,5});
        ListNode l2 = new ListNode(new int[]{1,3,4});
        ListNode l3 = new ListNode(new int[]{2,6});
        ListNode[] lists = new ListNode[]{l1,l2,l3};
        System.out.println(new Solution().mergeKLists(lists));
    }
}
