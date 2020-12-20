package com.jsgygujun.code.other._004_从尾到头打印链表;

import com.jsgygujun.code.util.ListNode;
import org.junit.Test;

import java.util.Stack;

/**
 * @author GuJun
 * @date 2020/12/20
 */
public class Solution {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> s = new Stack();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        int[] ret = new int[s.size()];
        int pos = 0;
        while (!s.isEmpty()) {
            ret[pos++] = s.pop();
        }
        return ret;
    }

    @Test
    public void test() {
        ListNode list = new ListNode(new int[]{1,2,3});
        int[] ans = reversePrint(list);
        for (int n : ans) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
