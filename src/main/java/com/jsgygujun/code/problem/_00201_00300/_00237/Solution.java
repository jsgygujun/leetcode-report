package com.jsgygujun.code.problem._00237;

import com.jsgygujun.code.util.ListNode;

/**
 * @author gujun@qiyi.com
 * @since 2020/6/19 12:51 下午
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val; // 把下一个节点的值copy过来
        node.next = node.next.next; // 删除下一个节点
    }
}
