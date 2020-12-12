package com.jsgygujun.code.problem._00001_00100._00023_合并K个升序链表;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

/**
 * 23. 合并K个排序链表
 *
 * 题目：
 * 合并「k」个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
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
        ListNode curr = dummy; // 遍历返回的List
        ListNode[] p = new ListNode[lists.length]; // 记录遍历的lists列表节点
        System.arraycopy(lists, 0, p, 0, lists.length); // 初始化c
        while (hasValidNode(p)) {
            int val = Integer.MAX_VALUE;
            int index = 0; // 记录值最小的节点所在的lists下标
            for (int i = 0; i < lists.length; ++i) {
                if (p[i] != null && p[i].val < val) {
                    val = p[i].val;
                    index = i; // 节点在链表数组中的下标
                }
            }
            curr.next = p[index];
            // curr.next = new ListNode(p[index].val) // 创建新节点
            p[index] = p[index].next;
            curr = curr.next;
        }
        return dummy.next;
    }

    // 是否遍历完了链表数组
    boolean hasValidNode(ListNode[] lists) {
        for (ListNode list : lists) {
            if (list != null) return true;
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
