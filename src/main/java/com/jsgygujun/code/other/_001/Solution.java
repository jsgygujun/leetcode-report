package com.jsgygujun.code.other._001;

import com.jsgygujun.code.util.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * 移除重复节点
 *
 * 题目：
 * 编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
 *
 * 示例1:
 *  输入：[1, 2, 3, 3, 2, 1]
 *  输出：[1, 2, 3]
 *
 * 示例2:
 *  输入：[1, 1, 1, 1, 2]
 *  输出：[1, 2]
 *
 * 提示：
 * 链表长度在[0, 20000]范围内。
 * 链表元素在[0, 20000]范围内。
 * 进阶：
 *
 * 如果不得使用临时缓冲区，该怎么解决？
 */
public class Solution {
    public ListNode removeDuplicateNodes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy.next;
        ListNode prev = dummy;
        while (curr != null) {
            if (set.contains(curr.val)) {
                prev.next = curr.next;
                curr = prev.next;
            } else {
                set.add(curr.val);
                prev = curr;
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicateNodes(new ListNode(new int[]{1,2,3,3,4,1})));
        System.out.println(new Solution().removeDuplicateNodes(new ListNode(new int[]{1,1,1,1,1,1,1,2})));
    }
}
